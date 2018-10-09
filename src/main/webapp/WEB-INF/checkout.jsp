<form action="${initParam['urlpaypal']}" method="POST" target="_top">
    <input type="hidden" name="business" value="saul.avila.harry@gmail.com"/>
    <input type="hidden" name="return" value="${initParam['urlretorno']}"/>
    <input type="hidden" name="cmd" value="_cart"/>
    <input type="hidden" name="upload" value="1"/>

    <c:forEach items="${sessionScope.cart}" var="pro">
        <c:set var="c" value="${c+1}"/>
        <input type="hidden" name="item_name_${c}" value="${pro.producto.nombre}"/>
        <input type="hidden" name="item_number_${c}" value="${pro.producto.webid}"/>
        <input type="hidden" name="amount_${c}" value="${pro.producto.precio}"/>
        <input type="hidden" name="quantity_${c}" value="${pro.cantidad}"/>
    </c:forEach>
        <input type="hidden" name="tax_cart_" value="${total*0.19}"/>
        <input type="hidden" name="currency_code" value="${moneda}"/>
        <input type="image" src="https://www.sandbox.paypal.com/es_ES/ES/i/btn/btn_buy_LG.gif" border="0" name="submit" alt="Paypal la forma segura de pagar por internet"/>
        <img alt="" border="0" src="htttps://www.sandbox.paypal.com/es_ES/i/src/pixel.gif" width="1" height="1"/>

</form>