<%@page import="admin.admin.model.vo.Admin"%>
<%@page import="admin.admin.model.service.AdminService"%>
<%@page import="admin.portfolio.model.vo.Portfolio"%>
<%@page import="admin.portfolio.model.service.PortfolioService"%>
<%@page import="admin.project.model.vo.Project"%>
<%@page import="admin.project.model.service.ProjectService"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="admin.ads.model.service.AdsService"%>
<%@page import="admin.ads.model.dao.AdsDao"%>
<%@page import="admin.ads.model.vo.Asset"%>
<%@page import="admin.ads.model.vo.Ads"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <% 
   ArrayList<Ads> alist = (ArrayList<Ads>)request.getAttribute("alist"); //선언부분
   ArrayList<Asset> aslist = (ArrayList<Asset>)request.getAttribute("aslist"); 
   
   Asset ass = new Asset();
   AdsDao ad = new AdsDao();
   
   
   ProjectService ps = new ProjectService();//프로젝트 가져오기부분
   ArrayList<Project> plist = new ArrayList<Project>();
   plist = ps.readProject();
   int pcount=0;
   for(int i=0;i<plist.size();i++){
	  if(plist.get(i).getStatus().equals("N")){
		  pcount++;
	  }
   }
   
   PortfolioService fs = new PortfolioService();
   ArrayList<Portfolio> flist = new ArrayList<Portfolio>();
   flist = fs.readPortfolio();
   int fcount=0;
   for(int i=0;i<flist.size();i++){
		  if(flist.get(i).getPoYn().equals("N")){
			  fcount++;
		  }
	   }
	   
   
   
   AdsService as = new AdsService();
   ArrayList<Asset> asslist = new ArrayList<Asset>();
  asslist = as.readAs();
  int total = 0;
 int revenueTotal =0;
 int adsTotal =0;
  
  for(int i=0;i<asslist.size();i++){//수익 담는 포문
  total += asslist.get(i).getpCost();
  revenueTotal += asslist.get(i).getpCost()*0.05;
  adsTotal += asslist.get(i).getAssetAdsRevenue();
  
  }
  int raTotal = revenueTotal+adsTotal;
  
  DecimalFormat formatter = new DecimalFormat("###,###");//돈 포멧
  
  String to = formatter.format(revenueTotal);
  String ra = formatter.format(adsTotal);
   
 
   
%>    
<!DOCTYPE html>
<html lang="en">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>winwin admin page</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">
<%@include file="header.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800"><sup>win</sup>win</h1>
            
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
            <a href="/admin0/asRead.do">
              <div class="card border-left-primary shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-s font-weight-bold text-primary text-uppercase mb-1">총 수수료 수익</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800"><%= to %>원</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
</a>
            </div>
            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
            <a href="/admin0/adsRead.do">
              <div class="card border-left-success shadow h-100 py-2">
                <div class="card-body">
                  <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                      <div class="text-s font-weight-bold text-success text-uppercase mb-1">총 광고 수익</div>
                      <div class="h5 mb-0 font-weight-bold text-gray-800"><%= ra %>원</div>
                    </div>
                    <div class="col-auto">
                      <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                    </div>
                  </div>
                </div>
              </div>
              </a>
            </div>

            <!-- Earnings (Monthly) Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <a href="/admin0/projectRead.do">
                <div class="card border-left-info shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row no-gutters align-items-center">
                      <div class="col mr-2">
                        <div class="text-s font-weight-bold text-info text-uppercase mb-1">프로젝트 승인 대기</div>
                          <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800"><%= pcount %> 건</div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-file-signature fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
            </div>

            <!-- Pending Requests Card Example -->
            <div class="col-xl-3 col-md-6 mb-4">
              <a href="/admin0/portfolioRead.do">
                <div class="card border-left-warning shadow h-100 py-2">
                  <div class="card-body">
                    <div class="row no-gutters align-items-center">
                      <div class="col mr-2">
                        <div class="text-s font-weight-bold text-warning text-uppercase mb-1">포트폴리오 승인 대기</div>
                        <div class="h5 mb-0 font-weight-bold text-gray-800"><%= fcount %> 건</div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-address-card fa-2x text-gray-300"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </a>
            </div>


          </div>

          <!-- Content Row -->

          <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">매출 개요</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-area">
                    <canvas id="myAreaChart"></canvas>
                  </div>
                </div>
              </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5">
              <div class="card shadow mb-4">
                <!-- Card Header - Dropdown -->
                <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                  <h6 class="m-0 font-weight-bold text-primary">회원 현황</h6>
                  <div class="dropdown no-arrow">
                    <a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                      <i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right shadow animated--fade-in" aria-labelledby="dropdownMenuLink">
                      <div class="dropdown-header">Dropdown Header:</div>
                      <a class="dropdown-item" href="#">Action</a>
                      <a class="dropdown-item" href="#">Another action</a>
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                  </div>
                </div>
                <!-- Card Body -->
                <div class="card-body">
                  <div class="chart-pie pt-4 pb-2">
                    <canvas id="myPieChart"></canvas>
                  </div>
                  <div class="mt-4 text-center small">
                    <span class="mr-2">
                      <i class="fas fa-circle text-success"></i> 기업회원
                    </span>
                    <span class="mr-2">
                      <i class="fas fa-circle text-primary"></i> 개발자회원
                    </span>
                  
                  </div>
                </div>
              </div>
            </div>
          </div>

          <!-- Content Row -->
          <div class="row">

            <!-- Content Column -->
            <div class="col-lg-6 mb-4">


            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">×</span>
          </button>
        </div>
        <div class="modal-body">로그아웃 하시겠습니까?</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/chart.js/Chart.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/chart-area-demo.js"></script>
  <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>
