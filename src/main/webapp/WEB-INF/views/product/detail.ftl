
<div class="product-container">
    <div class="container">

        <div class="product-top product">
            <div class="row">

                <div class="col-md-6">
                    <div class="product-image-slider">
                        <div class="col-xs-2">
                            <div class="product-image-slider">
                                <ul class="bxslider" id="prod-image-slider">
                                    <#assign slidercnt=0>
                                    <#list productExt.sliderImages as image>
                                        <#if slidercnt == 0>
                                        <li class="active">
                                        <#else>
                                        <li>
                                        </#if>
                                            <div class="prod-image">
                                                <div class="prod-image-inner">
                                                    <a href="#">
                                                        <img src="${image}" alt="">
                                                    </a>
                                                </div>
                                                <div class="arrow"></div>
                                            </div>
                                        </li>
                                        <#assign slidercnt=1>
                                    </#list>
                                </ul><!-- /.bxslider -->

                                <div class="owl-controls">
                                    <a href="#" id="prod-image-next" class="owl-next"></a>
                                    <a href="#" id="prod-image-prev" class="owl-prev"></a>
                                </div>
                            </div><!-- /.product-image-slider -->
                        </div><!-- /.col -->
                        <div class="col-xs-10">
                            <div class="product-image">
                                <div class="image">
                                    <a id="prod-image-link" href="${productExt.computerFirstImage}" data-lightbox="image-181476214" data-title="Nunc ullamcors">
                                        <img id="prod-image" src="${productExt.computerFirstImage}" alt="">
                                    </a>
                                </div>
                            </div>
                        </div><!-- /.col -->
                    </div><!-- /.product-image-slider -->
                </div><!-- /.col -->

                <div class="col-md-6">
                    <div class="product-info">
                        <h3 >${productExt.title1}</h3>
                        <#if productExt.title2??>
                            <h4 class="name">${productExt.title2}</h4>
                        </#if>
                        <div class="price-container info-container">
                            <div class="row">
                                <div class="col-sm-2">
                                    <div class="price-box">
                                        <span class="label">价格:</span>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="price-box">
                                        <span class="price">￥${productExt.price}</span>
                                    </div>
                                </div>

                                <div class="col-sm-3">
                                    <div class="price-box">
                                        <span class="price-strike">￥${productExt.prePrice}</span>
                                    </div>
                                </div>

                            </div><!-- /.row -->

                        </div><!-- /.price-container -->

                        <div class="info-container">
                            <div class="row">
                                <div class="col-sm-2">
                                    承诺：
                                </div>
                                <div class="col-sm-9">
                                    <ul class="list-unstyled ">
                                        <li>
                                            <ul class="list-unstyled list-inline">
                                                <li><b class="serv-info">01</b>正品保证</li>
                                                <li><b class="serv-info">02</b>终身保修</li>
                                            </ul>
                                        </li>
                                        <li>
                                            <ul class="list-unstyled list-inline">
                                                <li><b class="serv-info">03</b>全网低价</li>
                                                <li><b class="serv-info">04</b>微笑服务</li>
                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div id="saleinfo_div">
                            <#list productExt.saleItems as item>
                                <div class="info-container">
                                    <div class="row">
                                        <div class="col-sm-2">
                                            ${item.description}：
                                        </div>
                                        <div class="col-sm-9">
                                            ${item.value}
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </div>

                        <div class="info-container">
                            <div class="row">
                                <div class="col-sm-2">
                                    数量：
                                </div>
                                <div class="col-sm-2">
                                    <input type="text" class="txt txt-qty" value="10">
                                </div>
                            </div>
                        </div>
                        <div class="quantity-container info-container">
                            <div class="row">
                                <div class="col-sm-4">
                                    <a href="#" class="btn btn-blue btn-block btn-lg">立即购买</a>
                                </div>

                                <div class="col-sm-4">
                                    <a href="#" class="btn btn-blue btn-block btn-lg">加入购物车</a>
                                </div>
                            </div><!-- /.row -->
                        </div><!-- /.quantity-container -->

                    </div><!-- /.product-info -->
                </div><!-- /.col -->

            </div><!-- /.row -->
        </div><!-- /.product-top -->

        <div class="product-bottom">

            <div class="product-tabs">

                <ul class="nav nav-tabs nav-tab-cell" id="product-tabs">
                    <li class="active"><a href="#description" data-toggle="tab">商品描述</a></li>
                    <li><a href="#review" data-toggle="tab">规格信息</a></li>
                </ul><!-- /.nav-tabs #product-tabs -->

                <div class="tab-content">

                    <div class="tab-pane in active" id="description">
                        <div class="product-tab">
                        <#list productExt.contentImages as image>
                            <img src="${image}" class="img-responsive center-block" alt="Responsive image">
                        </#list>
                        </div>
                    </div><!-- /.tab-pane -->

                    <div class="tab-pane" id="review">
                        <div class="product-tab">
                            <p>
                               <#if productExt.specifications??>
                                   ${productExt.specifications}
                               <#else>
                                   暂无
                               </#if>
                            </p>
                        </div><!-- /.product-tab -->
                    </div><!-- /.tab-pane -->

                </div><!-- /.tab-content -->
            </div><!-- /.product-tabs -->

        </div><!-- /.product-bottom -->

        <!-- ============================================== CROSS SELLING ============================================== -->
        <section id="cross-selling" class="scroll-tabs">
            <h3 class="title-lined"><span>猜你喜欢</span></h3>
            <div class="product-slider">
                <div class="owl-carousel owl-theme prod-slider upsell-products">

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/3.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/11.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/8.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/9.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/7.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/4.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/12.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                    <div class="item">
                        <div class="product">
                            <div class="product-image">
                                <div class="image">
                                    <img data-echo="/resources/assets/images/products/2.jpg" src="/resources/assets/images/blank.gif" alt="">
                                </div>
                                <div class="cart">
                                    <div class="action">
                                        <div><a href="#" class="btn btn-dark-blue btn-small-med btn-trans">Add to Cart</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-heart"></i> Add to wishlist</a></div>
                                        <div><a href="#" class="lnk"><i class="fa fa-exchange"></i> Add to compare</a></div>
                                    </div>
                                </div>
                                <div class="tag tag-orange"><div class="text">HOT</div></div>
                            </div><!-- /.product-image -->

                            <div class="product-info">
                                <h3 class="name"><a href="#">Elizabeth PU Swing Dress</a></h3>
                                <div class="rating rateit-small"></div>
                                <div class="price"><span class="offer">$800.00</span><span class="actual">$900.00</span></div>
                            </div><!-- /.product-info -->
                        </div><!-- /.product -->				</div>

                </div><!-- /.prod-slider -->
            </div><!-- /.product-slider -->
        </section><!-- /.scroll-tabs -->
        <!-- ============================================== CROSS SELLING : END ============================================== -->
    </div><!-- /.container -->
</div><!-- /.product-container -->
