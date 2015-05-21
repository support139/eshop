/*price range*/

//$('#sl2').slider();

var RGBChange = function () {
    $('#RGB').css('background', 'rgb(' + r.getValue() + ',' + g.getValue() + ',' + b.getValue() + ')')
};

/*scroll to top*/

$(document).ready(function () {
    $(function () {
        $.scrollUp({
            scrollName: 'scrollUp', // Element ID
            scrollDistance: 300, // Distance from top/bottom before showing element (px)
            scrollFrom: 'top', // 'top' or 'bottom'
            scrollSpeed: 300, // Speed back to top (ms)
            easingType: 'linear', // Scroll to top easing (see http://easings.net/)
            animation: 'fade', // Fade, slide, none
            animationSpeed: 200, // Animation in speed (ms)
            scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
            //scrollTarget: false, // Set a custom target element for scrolling to the top
            scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
            scrollTitle: false, // Set a custom <a> title if required.
            scrollImg: false, // Set true to use image
            activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
            zIndex: 2147483647 // Z-Index for the overlay
        });
    });

    $("#cardPayment").click(function(){
        $("#cardId").slideDown("fast");
    });
    $("#paypalPayment").click(function(){
            $("#cardId").slideUp("fast");
    });
    $("#bankPayment").click(function(){
                $("#cardId").slideUp("fast");
        });



});

function buyAjaxRequest(guitarId) {
    $.ajax({
        url: "AddToBasket",
        type: "POST",
        data: {
            id : guitarId
        },
        success: function (response) {
            var value = JSON.parse(response);
            $("#cart").text('(' + value.quantity + ')');
        }
    });
}

function quantityAjaxRequest(orderItemId, quantity) {
    $.ajax({
        url: "ChangeQuantity",
        type: "POST",
        data: {
            orderItemId : orderItemId,
            quantity : quantity
        },
        success: function (response) {
            var currentRow = $("#" + orderItemId);
            var orderPrice = parseInt(currentRow.find("td.cart_price").text());
            var currentQuantity = currentRow.find("td.cart_quantity").find("input").val();
            var totalOrderPriceCell = $(currentRow.find("td.cart_total").text(orderPrice * currentQuantity));
            updateBottomOrderRow();
        }
    });
}

function deleteOrderItemRequest(orderItemId){
    $.ajax({
        url: "RemoveOrderItem",
        type: "POST",
        data: {
            orderItemId : orderItemId
        },
        success: function(response){
            $("#" + orderItemId).remove();
            updateBottomOrderRow();
        }
    })

}

function updateBottomOrderRow(){
    var totalPrice = 0;
    var totalQuantity = 0;
    $("table.table").find("td.cart_total").each(function(){
        totalPrice += parseInt($(this).text());
    });
    $("table.table").find("td.cart_quantity").find("input").each(function(){
        totalQuantity += parseInt($(this).val());
    });
    $("#quantity").text("Quantity: " + totalQuantity);
    $("#total").text("Total: " + totalPrice + "$");
}









