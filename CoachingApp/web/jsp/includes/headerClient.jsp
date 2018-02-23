<%@include file="header.jsp" %>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
<!-- /.navbar-header -->

<!-- Menu en haut à droite: Profil, Notifications, messages etc... -->
<ul class="nav navbar-top-links navbar-right">
    <!-- Messages -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-messages">
            <li>
                <a href="#">
                    <div>
                        <strong>Jean-David</strong>
                        <span class="pull-right text-muted">
                            <em>Hier</em>
                        </span>
                    </div>
                    <div>Je pensais t'avoir dit de faire
                        tes 100 pompes journalières !</div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <strong>Jean-David</strong>
                        <span class="pull-right text-muted">
                            <em>Il y adeux jours</em>
                        </span>
                    </div>
                    <div>Fais tes 100 pompes journalières !</div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a class="text-center" href="#">
                    <strong>Lire tous les messages</strong>
                    <i class="fa fa-angle-right"></i>
                </a>
            </li>
        </ul>
        <!-- /.dropdown-messages -->
    </li>
    
    <!-- Programme -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-tasks">
            <li>
                <a href="#">
                    <div>
                        <p>
                            <strong>Remise en forme</strong>
                            <span class="pull-right text-muted">40% Terminé</span>
                        </p>
                        <div class="progress progress-striped active">
                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                <span class="sr-only">40% Terminé</span>
                            </div>
                        </div>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
        </ul>
        <!-- /.dropdown-tasks -->
    </li>
    
    <!-- Notifications -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-alerts">
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-comment fa-fw"></i> Jean David vous 
                                invite à faire des pompes.
                        <span class="pull-right text-muted small">4 minutes ago</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-comment fa-fw"></i> Jean David vous 
                                invite à faire des pompes.
                        <span class="pull-right text-muted small">8 minutes ago</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-comment fa-fw"></i> Jean David vous 
                                invite à faire des pompes.
                        <span class="pull-right text-muted small">12 minutes ago</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-comment fa-fw"></i> Jean David vous 
                                invite à faire des pompes.
                        <span class="pull-right text-muted small">16 minutes ago</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a href="#">
                    <div>
                        <i class="fa fa-comment fa-fw"></i> Jean David vous 
                                invite à faire des pompes.
                        <span class="pull-right text-muted small">20 minutes ago</span>
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li>
                <a class="text-center" href="#">
                    <strong>Voir toutes les notifications</strong>
                    <i class="fa fa-angle-right"></i>
                </a>
            </li>
        </ul>
        <!-- /.dropdown-alerts -->
    </li>
    
    <!-- Options -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="#"><i class="fa fa-user fa-fw"></i> Votre profil</a>
            </li>
            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configuration</a>
            </li>
            <li class="divider"></li>
            <li><a href="ServletDeconnexion"><i class="fa fa-sign-out fa-fw"></i> Se déconnecter</a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
</ul>

<!-- Menu latéral -->
<div class="navbar-default sidebar" role="navigation">
    <div class="sidebar-nav navbar-collapse">
        <ul class="nav" id="side-menu">
            
        </ul>
    </div>
    <!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->
</nav>

<div id="page-wrapper">
