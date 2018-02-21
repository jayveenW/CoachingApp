<%-- 
    Document   : AfficherExercice
    Created on : 21 févr. 2018, 05:48:57
    Author     : Bastien
--%>
<%@include file="../includes/headerCoach.jsp" %>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Exercices</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Liste des exercices
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                            <tr>
                                <th>Catégorie</th>
                                <th>Libellé</th>
                                <th>Difficulté</th>
                                <th>Descriptif</th>
                                <th>Photo</th>
                                <th>Vidéo</th>
                                <th>Recommandations</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="odd gradeX">
                                <td>Trident</td>
                                <td>Internet Explorer 4.0</td>
                                <td>Win 95+</td>
                                <td class="center">4</td>
                                <td class="center">X</td>
                            </tr>
                            <%!
                               /* private final Logger logger = new Logger(this.getClass());
                                private UserService userService = null;
                                public void jspInit() {
                                    userService = new UserService();
                                }
                                private String getUserStatus(String userID) {
                                    return userServce.getUserStatus(userID);
                                }*/
                            %>
                        </tbody>
                    </table>
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
<%@include file="../includes/footer.jsp" %>
