package com.homework.homework16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlayCard {
	public static void main(String[] args) {
		// 定义点数
		String[] point = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "jake", "queen", "king", "ace" };
		// 定义花色
		String[] fC = { "RED ", "JOKER ", "BLACK ", "JOKER " };
		// 定义扑克集合
		TreeMap<Integer, String> mapPoker = new TreeMap<>();
		// 生成扑克
		int sum = 0;
		for (String s1 : point) {
			for (String s2 : fC) {
				mapPoker.put(++sum, s2.concat(s1));
			}
		}
		mapPoker.put(++sum, "RED JOKER");
		mapPoker.put(++sum, "BLACK JOKER");
		// System.out.println(mapPoker + "\n");

		// 获取所有键
		Set<Integer> keys = mapPoker.keySet();
		// 把键个封装到ArrayList集合，便于使用Collections集合工具类洗牌
		ArrayList<Integer> poker = new ArrayList<>();
		for (Integer integer : keys) {
			poker.add(integer);
		}
		// System.out.println("洗牌前key：" + poker);

		// 洗牌
		// 使用集合工具类洗牌
		Collections.shuffle(poker);
		// System.out.println("洗牌后key：" + poker + "\n" + poker.size());

		// 派牌、码牌(TreeSet)，定义了三个人man1、man2、man3，底牌 diPoker
		TreeSet<Integer> man1 = new TreeSet<>();
		TreeSet<Integer> man2 = new TreeSet<>();
		TreeSet<Integer> man3 = new TreeSet<>();
		ArrayList<Integer> diPoker = new ArrayList<>(poker.subList(poker.size() - 3, poker.size()));
		// 每人一张发牌
		for (int i = 0; i < poker.size() - 3; i++) {
			Integer s = poker.get(i);
			if (i % 3 == 1) {
				man1.add(s);
			} else if (i % 3 == 2) {
				man2.add(s);
			} else if (i % 3 == 0) {
				man3.add(s);
			}
		}

		// 看牌
		// 三方牌装到ArrayList便于每个man遍历打印
		ArrayList<Set<Integer>> sets = new ArrayList<>();
		sets.add(man1);
		sets.add(man2);
		sets.add(man3);
		// 外层遍历ArrayList的man封装，内层打印牌
		for (int i = 0; i < sets.size(); i++) {
			// 三目嵌套打出每个人
			System.out.print(i == 0 ? "man1：" : (i == 1 ? "man2：" : (i == 2 ? "man3：" : "")));
			Set<Integer> set = sets.get(i);
			for (Integer te : set) {
				System.out.print(mapPoker.get(te) + "   ");
			}
			System.out.println();
		}
		// 打印底牌
		System.out.print("\ndiPoker：");
		for (Integer te : diPoker) {
			System.out.print(mapPoker.get(te) + "   ");
		}
	}
}

//编写一个自动发牌程序，模拟三人斗地主的摸牌场景。首先要给出提示，谁首先开始摸牌，并且摸牌要和现实摸牌一样，
//三人循环摸牌，最后还要剩余三张底牌，同时给出地主牌，摸到地主牌的玩家拥有三张底牌。三张底牌三人都可以看到。
//当三张底牌派发给地主后提示玩家摸牌结束 
//
//实现思路
//
//1）首先将一副牌的四种花色和对应的牌面值随机组合放进Set集合，因为Set集合是非重复集合，所以无需考虑
//重复的问题，另外，因为每个牌面值出现的次数只能是四次，所以，当该牌面值出现了四次以后，将该牌面删除。
//    
//2）获取洗牌结束的牌组（链表，用Set集合作为初始化数据集），随机额抽取三张牌，作为底牌，
//不对玩家展示，并从剩余的牌组中随机选取一个张牌，作为地主牌，对所有人展示但不移动其位置。
//    
//3）顺序循环发牌，直到牌组没有牌为止，将底牌展示并发给地主。提示玩家发牌结束。
//
//
//
//实现效果：
//地主牌是：heart 9
//派牌开始！
//...
//派牌结束！
//底牌是：[spade 6, diamond 4, spade King]
//地主是玩家A
//玩家A的手牌是：
//【 heart Queen, heart Jack, club Ace, heart 6, heart 9, heart 5, 
//club Queen, diamond King, diamond 6, diamond 8, club 3, club 6, 
//club 8, club Jack, heart 10, spade 8, spade 9, spade 6, 
//diamond 4, spade King 】
//玩家B的手牌是：
//【 diamond Jack, spade Queen, spade Ace, heart 7, heart 8, heart 2, 
//club 10, diamond 2, diamond 5, diamond 9, club 4, heart Ace, 
//club 9, spade 2, spade 3, spade 10, RED JOKER 】
//玩家C的手牌是：
//【 BLACK JOKER, diamond Queen, diamond 10, club King, heart 3, heart 4, 
//diamond 3, diamond 7, diamond Ace, club 2, club 5, club 7, 
//heart King, spade 4, spade 5, spade 7, spade Jack 】
//
//heart spade club diamond 13 * 4 52
//RED JOKER BLACK JOKER

// 17*3 = 51 54