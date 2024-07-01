<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information Page</title>
<link rel="stylesheet" href="css/info/info.css" />
</head>
<body>
	<section class="info_container">
		<div class="info_title_box">
			<h1>情報一覧</h1>
			<a href="InfoAllC?num=0">#Show All</a>
		</div>

		<!-- child -->
		<div class="info_child_container">
			<div class="info_ul_title_box">
				<p class="info_title" id="info_title"># 子供</p>
				<div class="info_title_img_box" id="info_title_img_box">
					<img class="info_title_img" id="info_title_img" src="img/local/dongguri.svg"/>
				</div>
				<button class="info_all" id="info_all" onclick="goInfo(1)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="https://ecolife-coco.com/wp-content/themes/coco/assets/images/logo_main.png" onclick="goSite(1)" class="content_img"/></li>
				<li><img src="https://www.osaka-kodomoshien.com/images/ver3/fusho.png" onclick="goSite(2)" class="content_img" /></li>
				<li><img src="https://jspedanes.smoosy.atlas.jp/files/SITE_HEADER?locale=ja" onclick="goSite(3)" class="content_img" /></li>
				<li><img src="https://litalico-c.jp/packs/assets/9b31c2e6612b0df64362ebf233df0386.svg" onclick="goSite(4)" class="content_img" /></li>
				<li><img src="https://www.cfa.go.jp/themes/custom/gov_theme_cfa_2023/logo.svg" onclick="goSite(5)" class="content_img" /></li>
				<li><img src="https://www.mcfh.or.jp/images/c-sprite01.png" onclick="goSite(6)" class="content_img" /></li>
				<li><img src="http://www.rehab.go.jp/application/files/thumbnails/large/9115/1428/0851/footer_img_nrco.png" onclick="goSite(7)" class="content_img" /></li>
				<li><img src="https://www.midwife.or.jp/user/media/midwife/layout/header/logo.png" onclick="goSite(8)" class="content_img" /></li>
				<li><img src="https://d2goguvysdoarq.cloudfront.net/packs/style_images/logo-bd347d2462459d7eca37.svg" onclick="goSite(9)" class="content_img" /></li>
				<li><img src="https://tokyo-eventplus.com/wp-content/themes/tep/img/common/header_logo.jpg" onclick="goSite(10)" class="content_img" /></li>
				<li><img src="https://static.wixstatic.com/media/5a3a17_788f7e83b8504defbf47f20ab57b4b91~mv2.png/v1/fill/w_59,h_59,al_c,q_85,enc_auto/logo.png" onclick="goSite(11)" class="content_img" /></li>
			</ul>
		</div>

		<!-- older -->
		<div class="info_older_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 老人</p>
				<button class="info_all" onclick="goInfo(2)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="https://nenrin.or.jp/common/img/logo.gif" onclick="goSite(1)" class="content_img"/></li>
				<li><img src="https://www.wam.go.jp/content/img/wamnet_logo_top.png" onclick="goSite(2)" class="content_img" /></li>
				<li><img src="img/local/info_older_3.png" onclick="goSite(3)" class="content_img" /></li>
				<li><img src="https://www.kyoukaikenpo.or.jp/assets/image/common/logo_01.png" onclick="goSite(4)" class="content_img" /></li>
				<li><img style="background-color: blue;" src="https://www.sawayakazaidan.or.jp/CMS2/wp-content/themes/sawayaka/assets/img/common/logo.svg" onclick="goSite(5)" class="content_img" /></li>
				<li><img src="http://www.zenrouren.com/shared/img/title.gif" onclick="goSite(6)" class="content_img" /></li>
				<li><img src="https://wabas.sakura.ne.jp/image/rogo.gif" onclick="goSite(7)" class="content_img" /></li>
				<li><img src="https://www.espa.or.jp/common/img/hd_h1.png" onclick="goSite(8)" class="content_img" /></li>
				<li><img src="https://www.niid.go.jp/eiken/img/eikenlogo.jpg" onclick="goSite(9)" class="content_img" /></li>
				<li><img src="https://www.gpif.go.jp/resources/images/common/logo.png" onclick="goSite(10)" class="content_img" /></li>
				<li><img src="https://www.kaigo-shien-kyokai.or.jp/img/logo-kaigo_shien_kyoukai.png" onclick="goSite(11)" class="content_img" /></li>
				<li><img src="https://www.roushikyo.or.jp/fs_shared/img/top/logo.png" onclick="goSite(12)" class="content_img" /></li>
			</ul>
		</div>

		<!-- animal -->
		<div class="info_animal_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 動物</p>
				<button class="info_all" onclick="goInfo(3)">More</button>
			</div>
			<ul class="info_ul_container">
<li><img src="https://www.jaws.or.jp/wp-content/themes/jaws/images/contents01-img01.jpg" onclick="goSite(1)" class="content_img"></li>
<li><img src="https://www.animaldonation.org/anidone/wp-content/themes/storefront_v2/common/images/sp_logo.svg" onclick="goSite(2)" class="content_img"></li>
<li><img src="https://dtj.or.jp/common/img/img_18.jpg" onclick="goSite(3)" class="content_img"></li>
<li><img src="https://kaws.jp/wp/wp-content/themes/kaws/img/logo1.svg" onclick="goSite(4)" class="content_img"></li>
<li><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxHJbHUcb2q6xcSW1k5wdEtqS5LbJO_c_oOA&s" onclick="goSite(5)" class="content_img"></li>
<li><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSU6AdDYUrp-0rC2c8gzUgBh67B5EJlOGmAhg&s" onclick="goSite(6)" class="content_img"></li>
<li><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTaSofD0S1hs3pMVWNPJUT86ebQjVDNnj0I8v1goOvYjuDErkqthmvtYA2zUcBDERYy3CQ&usqp=CAU" onclick="goSite(7)" class="content_img"></li>
<li><img src="https://www.j-animal.com/wp/wp-content/uploads/2018/12/logo-tate-green02.png" onclick="goSite(8)" class="content_img"></li>
<li><img src="https://arcj.org/wp-content/uploads/2019/01/logo1.png" onclick="goSite(9)" class="content_img"></li>
<li><img src="https://www.nihondoubutukaigo.com/img/logo-pc.png" onclick="goSite(10)" class="content_img"></li>
<li><img src="https://kspca.jp/wp-content/uploads/2021/01/logo1958.jpg" onclick="goSite(11)" class="content_img"></li>
			</ul>
		</div>

		<!-- env -->
		<div class="info_env_container">
			<div class="info_ul_title_box">
				<p class="info_title"># 環境</p>
				<button class="info_all" onclick="goInfo(4)">More</button>
			</div>
			<ul class="info_ul_container">
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
				<li><img src="" /></li>
			</ul>
		</div>
	</section>
	<script src="js/info/info.js"></script>
</body>
</html>