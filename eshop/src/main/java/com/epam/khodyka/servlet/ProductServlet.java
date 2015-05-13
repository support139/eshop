package com.epam.khodyka.servlet;

import com.epam.khodyka.Path;
import com.epam.khodyka.bean.FilterBean;
import com.epam.khodyka.db.entiry.Category;
import com.epam.khodyka.db.entiry.Guitar;
import com.epam.khodyka.db.entiry.Manufacturer;
import com.epam.khodyka.requestextractor.Extractor;
import com.epam.khodyka.requestextractor.impl.FilterBeanExtractor;
import com.epam.khodyka.service.CategoryService;
import com.epam.khodyka.service.ManufacturerService;
import com.epam.khodyka.service.ProductService;
import com.epam.khodyka.util.UrlBuilder;
import com.epam.khodyka.validator.Validator;
import com.epam.khodyka.validator.impl.FilterBeanValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/6/2015.
 */

@WebServlet("/Product")
public class ProductServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(ProductServlet.class);

    private CategoryService categoryService;
    private ManufacturerService manufacturerService;
    private ProductService productService;
    private Extractor<FilterBean> filterBeanExtractor;
    private Validator<FilterBean> filterBeanValidator;

    @Override
    public void init() throws ServletException {
        super.init();
        this.categoryService = (CategoryService) getServletContext().getAttribute("CategoryService");
        this.manufacturerService = (ManufacturerService) getServletContext().getAttribute("ManufacturerService");
        this.productService = (ProductService) getServletContext().getAttribute("ProductService");
        this.filterBeanExtractor = new FilterBeanExtractor();
        this.filterBeanValidator = new FilterBeanValidator();
        LOG.info("ProductServlet has been initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilterBean filterBean = filterBeanExtractor.extract(req);
        if (!filterBeanValidator.isValid(filterBean)) {
            LOG.error("URL parameters are not valid! Redirect with valid parameters");
            resp.sendRedirect(UrlBuilder.generate(filterBean));
            return;
        }
        List<Category> categories = categoryService.getAllCategories();
        List<Manufacturer> manufacturers = manufacturerService.getAllManufacturers();
        List<Guitar> guitars = productService.getProductsByFilter(filterBean);
        int numOfPages = (int) Math.ceil(1.0 * productService.getProductCount(filterBean) / filterBean.getLimit());

        req.setAttribute("queryString", UrlBuilder.generate(filterBean));
        req.setAttribute("Filter", filterBean);
        req.setAttribute("Categories", categories);
        req.setAttribute("Manufacturers", manufacturers);
        req.setAttribute("Guitars", guitars);
        req.setAttribute("numOfPages", numOfPages);

        LOG.info("OK! Forward to show page!");
        req.getRequestDispatcher(Path.SHOP_PAGE).forward(req, resp);
    }
}
