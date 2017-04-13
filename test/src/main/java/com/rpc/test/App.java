package com.rpc.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
	
	static String words = "国家级,世界级,最高级,第一,唯一,首个,首选,顶级,国家级产品,填补国内空白,独家,首家,最新,最先进,第一品牌,金牌,名牌,优秀,顶级,独家,全网销量第一,全球首发,全国首家,全网首发,世界领先,顶级工艺,王牌,销量冠军,第一,NO1,Top1,极致,永久,王牌,掌门人,领袖品牌,独一无二,绝无仅有,史无前例,万能,最高,最低,最,最具,最便宜,最新,最先进,最大程度,最新技术,最先进科学,最佳,最大,最好,最大,最新科学,最新技术,最先进加工工艺,最时尚,最受欢迎,最先,绝对,大牌,精确,超赚,领导品牌,领先上市,巨星,著名,奢侈,世界全国X大品牌之一,100%,国际品质,高档,正品,国家级,世界级,最高级,最佳,仅此一次,随时涨价,马上降价,最后一波,领导人推荐,机关推荐,机关专供,特供等借国家,质量免检,无需国家质量检测,免抽检,老字号,中国驰名商标,特供,专供,恭喜获奖,全民免单,点击有惊喜,点击获取,点击试穿,领取奖品,非转基因更安全,秒杀,抢爆,再不抢就没了,不会再便宜了,错过就没机会了,万人疯抢,抢疯了,带来好运气，增强第六感,化解小人,增加事业运,招财进宝,健康富贵,提升运气,有助事业,护身,平衡正负能量,消除精神压力,调和气压,逢凶化吉,时来运转,万事亨通,旺人,旺财,助吉避凶,转富招福,特效,高效,全效,强效,速效,速白,一洗白,天见效,周期见效,超强,激活,全方位,全面,安全,无毒,溶脂、吸脂、燃烧脂肪,瘦身,瘦脸,瘦腿,减肥,延年益寿,提高记忆力,保护记忆力,提高,肌肤抗刺激,消除,清除,化解死细胞,去除皱纹,祛除皱纹,平皱,修复断裂弹性纤维,止脱,采用新型着色机理永不褪色,迅速修复受紫外线伤害的肌肤,更新肌肤,破坏黑色素细胞,阻断黑色素的形成,阻碍黑色素的形成,丰乳,丰胸,使乳房丰满,预防乳房松弛下垂,改善睡眠,促进睡眠,舒眠";
	static String[] wordArr = words.split(",");

	
	public static void main(String[] args) {
		List<Table> tableList = new ArrayList<>();
		tableList.add(new Table("tbl_business_area", "description", "商圈"));
		tableList.add(new Table("tbl_feedback_reply", "content", "意见反馈"));
		tableList.add(new Table("tbl_store", "store_name,store_sub_title,description,address", "店铺"));
		tableList.add(new Table("tbl_store_assessment", "description,u_address", "店铺评价"));
		tableList.add(new Table("tbl_store_assessment_comment", "content", "店铺评论"));
		tableList.add(new Table("tbl_store_assessment_pic", "content,content_tc", "评价与图片关联表"));
		tableList.add(new Table("tbl_store_assessment_spider", "name,content", "店铺商家评论"));
		tableList.add(new Table("tbl_store_error", "reason", "店铺纠错"));
		tableList.add(new Table("tbl_store_line", "title,description", "店铺线路"));
		tableList.add(new Table("tbl_store_recommend", "`desc`", "店铺推荐"));
		tableList.add(new Table("tbl_store_topic", "title,description", "店铺专题"));
		tableList.add(new Table("tbl_store_topic_detail", "description", "店铺专题详情"));
		
		try {
			
			List<String> sqlList = new ArrayList<>();
			for (Table table : tableList) {
				sqlList.add("select id, '"+ table.getTableComment() +"' tableData from "+ table.getTableName() +" where " + param(table));
			}
			
			System.out.println("select * from (" + StringUtils.join(sqlList, "\r\n union ") + ") a order by tableData, id");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String param(Table table) {
		List<String> l = new ArrayList<>();
		String[] arr = table.getFields().split(",");
		for (String f : arr) {
			for (String w : wordArr) {
				l.add("instr("+ f +", '"+ w +"')>0");
			}
		}
		return StringUtils.join(l, " or ");
	}
	
	public static class Table {
		/**
		 * @param tableName
		 * @param fields
		 * @param tableComment
		 */
		public Table(String tableName, String fields, String tableComment) {
			super();
			this.tableName = tableName;
			this.fields = fields;
			this.tableComment = tableComment;
		}
		private String tableName;
		private String fields;
		private String tableComment;
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public String getFields() {
			return fields;
		}
		public void setFields(String fields) {
			this.fields = fields;
		}
		public String getTableComment() {
			return tableComment;
		}
		public void setTableComment(String tableComment) {
			this.tableComment = tableComment;
		}
	}
}
