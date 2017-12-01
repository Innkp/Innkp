package com.innkp.Innkp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innkp.Innkp.dao.CorpsDao;
import com.innkp.Innkp.dto.CorpsDTO;
import com.innkp.Innkp.dto.CorpssDTO;
import com.innkp.Innkp.entity.CorpsDo;

/**
 *
 * @author yangxue9
 */
@Service
public class CorpsService {
	@Autowired
	private DTOHelper dtoHelper;
	@Autowired
	private CorpsDao corpsDao;

	public CorpsDTO getCorpsByName(String name) {
		CorpsDo corps = corpsDao.findByName(name);
		if (corps != null) {
			return dtoHelper.buildCorpsDTO(corps);
		} else {
			return null;
		}
	}

	public CorpssDTO getCorpsById(Long id) {
		CorpssDTO dto = new CorpssDTO();
		List<CorpsDTO> corpss = new ArrayList<CorpsDTO>();
		CorpsDo corps = corpsDao.findOne(id);
		if (corps != null) {
			corpss.add(dtoHelper.buildCorpsDTO(corps));
			dto.list = corpss;
		} else {
			return null;
		}
		return dto;
	}

	public CorpssDTO getCorpssDTO() {
		CorpssDTO dto = new CorpssDTO();
		List<CorpsDTO> corpss = new ArrayList<CorpsDTO>();
		Iterable<CorpsDo> corpsIt = corpsDao.findAll();

		corpsIt.forEach(single -> {
			corpss.add(dtoHelper.buildCorpsDTO(single));
		});
		dto.list = corpss;
		return dto;
	}

	public boolean save(String name, String captain, String label, String details) {
		CorpsDo c1 = new CorpsDo();
		c1.setName(name);
		c1.setCaptain(captain);
		c1.setLabel(label);
		c1.setDetails(details);
		c1.setNum(1);
		c1.setCreatedDate(new Date());
		corpsDao.save(c1);
		System.out.println(c1.toString());
		return true;
	}

	public boolean update(String corpsId) {
		CorpsDo c1 = corpsDao.findOne(Long.parseLong(corpsId));
		int num = c1.getNum();
		if (num < 10) {
			c1.setNum(num + 1);
			corpsDao.save(c1);
			return true;
		} else
			return false;
	}

	public void initData() {
		// corpsDao.deleteAll();
		CorpsDo c1 = new CorpsDo();
		c1.setName("精致的男孩");
		c1.setCaptain("呆呆");
		c1.setLabel("不瘦就出局的发起人，be better 班长，撩妹达人");
		c1.setDetails(text);
		c1.setNum(100);
		c1.setCreatedDate(new Date());
		c1 = corpsDao.save(c1);
	}

	private String text = "人之初，性本善。性相近，习相远。\n" + "苟不教，性乃迁。教之道，贵以专。\n" + "昔孟母，择邻处。子不学，断机杼。\n" + "窦燕山，有义方。教五子，名俱扬。\n"
			+ "养不教，父之过。教不严，师之惰。\n" + "子不学，非所宜。幼不学，老何为。\n" + "玉不琢，不成器。人不学，不知义。\n" + "为人子，方少时。亲师友，习礼仪。\n"
			+ "香九龄，能温席。孝于亲，所当执。\n" + "融四岁，能让梨。弟于长，宜先知。\n" + "首孝悌，次见闻。知某数，识某文。\n" + "一而十，十而百。百而千，千而万。\n"
			+ "三才者，天地人。三光者，日月星。\n" + "三纲者，君臣义。父子亲，夫妇顺。\n" + "曰春夏，曰秋冬。此四时，运不穷。\n" + "曰南北，曰西东。此四方，应乎中。\n"
			+ "曰水火，木金土。此五行，本乎数。\n" + "十干者，甲至癸。十二支，子至亥。\n" + "曰黄道，日所躔。曰赤道，当中权。\n" + "赤道下，温暖极。我中华，在东北。\n"
			+ "曰江河，曰淮济。此四渎，水之纪。\n" + "曰岱华，嵩恒衡。此五岳，山之名。\n" + "曰士农，曰工商。此四民，国之良。\n" + "曰仁义，礼智信。此五常，不容紊。\n"
			+ "地所生，有草木。此植物，遍水陆。\n" + "有虫鱼，有鸟兽。此动物，能飞走。\n" + "稻粱菽，麦黍稷。此六谷，人所食。\n" + "马牛羊，鸡犬豕。此六畜，人所饲。\n"
			+ "曰喜怒，曰哀惧。爱恶欲，七情具。\n" + "青赤黄，及黑白。此五色，目所识。\n" + "酸苦甘，及辛咸。此五味，口所含。\n" + "膻焦香，及腥朽。此五臭，鼻所嗅。\n"
			+ "匏土革，木石金。丝与竹，乃八音。\n" + "曰平上，曰去入。此四声，宜调协。\n" + "高曾祖，父而身。身而子，子而孙。\n" + "自子孙，至玄曾。乃九族，人之伦。\n"
			+ "父子恩，夫妇从。兄则友，弟则恭。\n" + "长幼序，友与朋。君则敬，臣则忠。\n" + "此十义，人所同。当师叙，勿违背。\n" + "斩齐衰，大小功。至缌麻，五服终。\n"
			+ "礼乐射，御书数。古六艺，今不具。\n" + "惟书学，人共遵。既识字，讲说文。\n" + "有古文，大小篆。隶草继，不可乱。\n" + "若广学，惧其繁。但略说，能知原。\n"
			+ "凡训蒙，须讲究。详训诂，明句读。\n" + "为学者，必有初。小学终，至四书。\n" + "论语者，二十篇。群弟子，记善言。\n" + "孟子者，七篇止。讲道德，说仁义。\n"
			+ "作中庸，子思笔。中不偏，庸不易。\n" + "作大学，乃曾子。自修齐，至平治。\n" + "孝经通，四书熟。如六经，始可读。\n" + "诗书易，礼春秋。号六经，当讲求。\n"
			+ "有连山，有归藏。有周易，三易详。\n" + "有典谟，有训诰。有誓命，书之奥。\n" + "我周公，作周礼。著六官，存治体。\n" + "大小戴，注礼记。述圣言，礼乐备。\n"
			+ "曰国风，曰雅颂。号四诗，当讽咏。\n" + "诗既亡，春秋作。寓褒贬，别善恶。\n" + "三传者，有公羊。有左氏，有谷梁。\n" + "经既明，方读子。撮其要，记其事。\n"
			+ "五子者，有荀扬。文中子，及老庄。\n" + "经子通，读诸史。考世系，知始终。\n" + "自羲农，至黄帝。号三皇，居上世。\n" + "唐有虞，号二帝。相揖逊，称盛世。\n"
			+ "夏有禹，商有汤。周武王，称三王。\n" + "夏传子，家天下。四百载，迁夏社。\n" + "汤伐夏，国号商。六百载，至纣亡。\n" + "周武王，始诛纣。八百载，最长久。\n"
			+ "周辙东，王纲坠。逞干戈，尚游说。\n" + "始春秋，终战国。五霸强，七雄出。\n" + "嬴秦氏，始兼并。传二世，楚汉争。\n" + "高祖兴，汉业建。至孝平，王莽篡。\n"
			+ "光武兴，为东汉。四百年，终于献。\n" + "魏蜀吴，争汉鼎。号三国，迄两晋。\n" + "宋齐继，梁陈承。为南朝，都金陵。\n" + "北元魏，分东西。宇文周，与高齐。\n"
			+ "迨至隋，一土宇。不再传，失统绪。\n" + "唐高祖，起义师。除隋乱，创国基。\n" + "二十传，三百载。梁灭之，国乃改。\n" + "梁唐晋，及汉周。称五代，皆有由。\n"
			+ "炎宋兴，受周禅。十八传，南北混。\n" + "辽与金，皆称帝。元灭金，绝宋世。\n" + "舆图广，超前代。九十年，国祚废。\n" + "太祖兴，国大明。号洪武，都金陵。\n"
			+ "迨成祖，迁燕京。十六世，至崇祯。\n" + "权阉肆，寇如林。李闯出，神器焚。\n" + "清世祖，膺景命。靖四方，克大定。\n" + "由康雍，历乾嘉。民安富，治绩夸。\n"
			+ "道咸间，变乱起。始英法，扰都鄙。\n" + "同光后，宣统弱。传九帝，满清殁。\n" + "革命兴，废帝制。立宪法，建民国。\n" + "古今史，全在兹。载治乱，知兴衰。\n"
			+ "史虽繁，读有次。史记一，汉书二。\n" + "后汉三，国志四。兼证经，参通鉴。\n" + "读史者，考实录。通古今，若亲目。\n" + "昔仲尼，师项橐。古圣贤，尚勤学。\n"
			+ "赵中令，读鲁论。彼既仕，学且勤。\n" + "披蒲编，削竹简。彼无书，且知勉。\n" + "头悬梁，锥刺股。彼不教，自勤苦。\n" + "如囊萤，如映雪。家虽贫，学不辍。\n"
			+ "如负薪，如挂角。身虽劳，犹苦卓。\n" + "苏老泉，二十七。始发愤，读书籍。\n" + "彼既老，犹悔迟。尔小生，宜早思。\n" + "若梁灏，八十二。对大廷，魁多士。\n"
			+ "彼既成，众称异。尔小生，宜立志。\n" + "莹八岁，能咏诗。泌七岁，能赋棋。\n" + "彼颖悟，人称奇。尔幼学，当效之。\n" + "蔡文姬，能辩琴。谢道韫，能咏吟。\n"
			+ "彼女子，且聪敏。尔男子，当自警。\n" + "唐刘晏，方七岁。举神童，作正字。\n" + "口而诵，心而惟。朝于斯，夕于斯。\n" + "晏虽幼，身已仕。有为者，亦若是。\n"
			+ "犬守夜，鸡司晨。苟不学，曷为人。\n" + "蚕吐丝，蜂酿蜜。人不学，不如物。\n" + "幼而学，壮而行。上致君，下泽民。\n" + "扬名声，显父母。光于前，裕于后。\n"
			+ "人遗子，金满赢。我教子，唯一经。\n" + "勤有功，戏无益。戒之哉，宜勉力。";

}