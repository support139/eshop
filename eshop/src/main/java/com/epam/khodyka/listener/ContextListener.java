package com.epam.khodyka.listener;

import com.epam.khodyka.captcha.CaptchaFactory;
import com.epam.khodyka.captcha.CaptchaService;
import com.epam.khodyka.db.ConnectionHolder;
import com.epam.khodyka.db.DbManager;
import com.epam.khodyka.db.ProductQueryBuilder;
import com.epam.khodyka.db.TransactionManager;
import com.epam.khodyka.db.repository.impl.*;
import com.epam.khodyka.service.*;
import com.epam.khodyka.service.impl.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.lang.reflect.Proxy;

/**
 * Application Lifecycle Listener implementation class ContextListener
 */
@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ConnectionHolder connectionHolder = new ConnectionHolder();
        DbManager dbManager = new DbManager();

        //  Repository init
        MySqlUserRepository userRepository = new MySqlUserRepository(dbManager, connectionHolder);
        MySqlCategoryRepository categoryRepository = new MySqlCategoryRepository(dbManager, connectionHolder);
        MySqlManufacturerRepository manufacturerRepository = new MySqlManufacturerRepository(dbManager, connectionHolder);
        MySqlProductRepository productRepository = new MySqlProductRepository(dbManager, connectionHolder);
        MySqlOrderRepository orderRepository = new MySqlOrderRepository(dbManager, connectionHolder);
        MySqlShopperRepository shopperRepository = new MySqlShopperRepository(dbManager, connectionHolder);
        MySqlOrderItemRepository orderItemRepository = new MySqlOrderItemRepository(dbManager, connectionHolder);

        //  UserService init
        UserServiceImpl userServiceImpl = new UserServiceImpl(userRepository);
        TransactionManager<UserService> userTransactionManager = new TransactionManager(userServiceImpl, dbManager, connectionHolder);
        UserService userService = createServiceProxy(userServiceImpl, userTransactionManager);
        //  CategoryService init
        CategoryService categoryServiceImpl = new CategoryServiceImpl(categoryRepository);
        TransactionManager<CategoryService> categoryTransactionManager = new TransactionManager(categoryServiceImpl, dbManager, connectionHolder);
        CategoryService categoryService = createServiceProxy(categoryServiceImpl, categoryTransactionManager);
        //  ManufacturerService init
        ManufacturerService manufacturerServiceImpl = new ManufacturerServiceImpl(manufacturerRepository);
        TransactionManager<ManufacturerService> manufacturerTransactionManager = new TransactionManager(manufacturerServiceImpl, dbManager, connectionHolder);
        ManufacturerService manufacturerService = createServiceProxy(manufacturerServiceImpl, manufacturerTransactionManager);

        ProductQueryBuilder productQueryBuilder = new ProductQueryBuilder();

        ProductServiceImpl productServiceImpl = new ProductServiceImpl(productRepository, productQueryBuilder);
        TransactionManager<ProductService> productTransactionManager = new TransactionManager(productServiceImpl, dbManager, connectionHolder);
        ProductService productService = createServiceProxy(productServiceImpl, productTransactionManager);

        OrderService orderServiceImpl = new OrderServiceImpl(orderRepository, shopperRepository, orderItemRepository);
        TransactionManager<OrderService> orderTransactionManager = new TransactionManager<>(orderServiceImpl, dbManager, connectionHolder);
        OrderService orderService = createServiceProxy(orderServiceImpl, orderTransactionManager);

        PictureService pictureService = new LocalPictureService();

        String captchaMode = event.getServletContext().getInitParameter(
                "captchaMode");
        int captchaExpiryTime = Integer.parseInt(event.getServletContext()
                .getInitParameter("captchaExpiryTime"));
        CaptchaService captchaService = CaptchaFactory.getInstance(
                captchaExpiryTime).getCaptchaService(captchaMode);

        event.getServletContext().setAttribute("UserService", userService);
        event.getServletContext().setAttribute("CategoryService", categoryService);
        event.getServletContext().setAttribute("ManufacturerService", manufacturerService);
        event.getServletContext().setAttribute("PictureService", pictureService);
        event.getServletContext().setAttribute("CaptchaService", captchaService);
        event.getServletContext().setAttribute("ProductService", productService);
        event.getServletContext().setAttribute("OrderService", orderService);
    }

    public void contextDestroyed(ServletContextEvent event) {

    }

    private <T> T createServiceProxy(T impl, TransactionManager manager) {
        return (T) Proxy.newProxyInstance(impl.getClass().getClassLoader(), impl.getClass().getInterfaces(), manager);
    }

}
