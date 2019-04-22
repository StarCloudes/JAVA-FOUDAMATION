package com.qianfeng.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DealCardsDemo {
	
	List<String> cardList = new ArrayList<>(); // 随机牌组的链表
	private List<String> bottomCards = new ArrayList<>(); // 底牌组
	private String landLordCard = null; // 地主牌
	
	private Random rm = new Random(); // 随机数生成对象实例
	
	private List<String> playerA = new ArrayList<>(); // 玩家A
	private List<String> playerB = new ArrayList<>(); // 玩家B
	private List<String> playerC = new ArrayList<>(); // 玩家C

	public static void main(String[] args) {
		DealCardsDemo dealCards = new DealCardsDemo(); // 初始化对象
		
		dealCards.dealCards(); // 派发牌
		
		System.out.println("玩家A的手牌是：");
		showCards(dealCards.getPlayerA());
		System.out.println("玩家B的手牌是：");
		showCards(dealCards.getPlayerB());
		System.out.println("玩家C的手牌是：");
		showCards(dealCards.getPlayerC());
	}
	
	// 发牌程序
	public void dealCards() {
		cardList = new ArrayList<>(getCardSet());
		// 获取三张底牌
		while (bottomCards.size() < 3) {
			// 随机从牌组中抽出一张牌（删除），并将该牌放入底牌中
			bottomCards.add(cardList.remove(rm.nextInt(cardList.size()))); 
		}

		landLordCard = cardList.get(rm.nextInt(cardList.size())); // 从剩余牌组中翻一张牌作为地主牌
		
		System.out.println("地主牌是：" + landLordCard);
		// 循环发牌个玩家A、玩家B和玩家C(假设玩家A先摸牌)
		int cardNuber = cardList.size();
		System.out.println("派牌开始！");
		System.out.println("...");
		for (int i = 1 ; i <= cardNuber ; i++ ){ // 如果
			if (i % 3 == 0) { // 如果下标+1是3的倍数，说明这张牌是玩家C的
				playerC.add(cardList.get(i - 1));
			} else if (i % 2 == 0) { // 否则，如果是2的倍数，说明这张牌是玩家B的
				playerB.add(cardList.get(i - 1));
			} else { // 否则，这张牌就是玩家A的
				playerA.add(cardList.get(i - 1));
			}
		}
		System.out.println("派牌结束！");
		System.out.println("底牌是：" + bottomCards);
		if (playerA.contains(landLordCard)) {
			System.out.println("地主是玩家A");
			while (!bottomCards.isEmpty()) {
				playerA.add(bottomCards.remove(0)); // 删除底牌牌组并将牌组中的牌派发给地主
			}
		} else if (playerB.contains(landLordCard)) {
			System.out.println("地主是玩家B");
			while (!bottomCards.isEmpty()) {
				playerB.add(bottomCards.remove(0)); // 删除底牌牌组并将牌组中的牌派发给地主
			}
		} else {
			System.out.println("地主是玩家C");
			while (!bottomCards.isEmpty()) {
				playerC.add(bottomCards.remove(0)); // 删除底牌牌组并将牌组中的牌派发给地主
			}
		}
		
	}
	
	// 随机牌组生成程序
	public Set<String> getCardSet() {
		
		Set<String> cardSet = new HashSet<>(); // 随机的Set牌组
		
		Map<String, Integer> timesCounter = new HashMap<>(); // 牌面值出现的次数
		
		List<String> cardColors = getCardColor(); // 牌面颜色链表
		List<String> cardValues = getCardValue(); // 牌面值链表
		
		// 如果牌面值的链表中还有值，说明牌组还没有初始化好
		while(!cardValues.isEmpty()) {
			String cardColor = cardColors.get(rm.nextInt(cardColors.size())); // 获取牌面颜色（随机）
			String cardValue = cardValues.get(rm.nextInt(cardValues.size())); // 获取牌面值（随机）
			String card = cardColor + " " + cardValue; // 获取随机的一张牌面值
			if (cardSet.add(card)) { // 向牌组插入该张牌，如果成功插入，说明该牌是第一次插入，有效
				if(timesCounter.containsKey(cardValue)) { // 如果牌面的值不是第一次插入，那么将该值的计数器加1
					timesCounter.put(cardValue, timesCounter.get(cardValue) + 1);
					if(4 == timesCounter.get(cardValue)) { // 如果该牌面值出现4次，说明该牌面值将不会在出现了
						cardValues.remove(cardValue); // 从牌面值得list中将该牌面值删除
					}
				} else { // 拍面值第一次插入，则将插入次数计数器置为1次
					timesCounter.put(cardValue, 1);
				}
			} 
		}
		
		cardSet.add("RED JOKER"); // 加入大王王牌
		cardSet.add("BLACK JOKER");	// 加入小王王牌
		
		return cardSet;
	}
	
	// 格式化输出链表数据
	public static void showCards(List<String> list) {
		System.out.print("【 ");
		int count = 0 ;
		while (!(list.size() == 1)) { //如果链表中的元素个数大于1，则输出格式是 ： 元素值 + ", "
			count++; // 计数器自增
			System.out.print(list.remove(0) + ", ");
			if (count % 6 == 0) { // 每6个元素换行一次
				System.out.println();
			}
		}
		System.out.println(list.remove(0) + " 】");
	}
	
	// 获取牌组中非大小王牌的牌面值
	public List<String> getCardValue() {
		List<String> cardValue = new ArrayList<>();
		
		// 牌面值
		cardValue.add("Ace");
		cardValue.add("2");
		cardValue.add("3");
		cardValue.add("4");
		cardValue.add("5");
		cardValue.add("6");
		cardValue.add("7");
		cardValue.add("8");
		cardValue.add("9");
		cardValue.add("10");
		cardValue.add("Jack");
		cardValue.add("Queen");
		cardValue.add("King");
		
		return cardValue;
	}
	
	// 获取牌组中牌的颜色（黑桃、红桃、方片和梅花）
	public List<String> getCardColor() {
		List<String> cardColor = new ArrayList<>();
		
		cardColor.add("spade"); // 黑桃
		cardColor.add("heart"); // 红桃
		cardColor.add("diamond"); // 方片
		cardColor.add("club"); // 梅花
		
		return cardColor;
	}

	// 获取玩家的手牌的get方法
	public List<String> getPlayerA() {
		return playerA;
	}

	public List<String> getPlayerB() {
		return playerB;
	}

	public List<String> getPlayerC() {
		return playerC;
	}
	
}

