<%/*@ page import=""*/%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle"
                data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span> 
                <span class="icon-bar"></span> 
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">SEMANTAXON</a>
        </div>

        <div class="collapse navbar-collapse" id="contentLinks">

            <ul class="nav navbar-nav">
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Reino">Reino</a>
                </li>
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Phylum">Phylum</a>
                </li>
                
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Clase">Clase</a>
                </li>
                
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Orden">Orden</a>
                </li>
                
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Familia"">Familia</a>
                </li>
                
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Genero">Genero</a>
                </li>
                <li
                    class="">
                    <a href="/jsp/categoria.jsp?class=Especie">Especie</a>
                </li>
            </ul>

            <ul class="nav navbar-nav pull-right">
                <li>                
                    <a class="nav logout"
                        href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Logout  (<span class="text-info" data-toggle="tooltip"
                            data-placement="bottom"
                            title=""> 
                        </span>) 
                         (<span class="text-info" data-toggle="tooltip"
                            data-placement="bottom"
                            title="#"> 
                        </span>) 
                    </a>  
                </li>
            </ul>

        </div>
    </div>
</div>