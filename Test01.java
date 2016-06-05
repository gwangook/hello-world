package com.ook.test01;

import java.util.Scanner;

import org.junit.Test;

/**
 * 방향이 있는 길을 가는 방법 수와 길 자국을 기록 하는 프로그램
 * input1 : 도시의개수(C) 길의개수(E)
 * input2 : 길의 좌표(space로 간격을 띄워줌)
6 8
1 2 1 3 4 1 3 2 3 4 2 5 3 5 5 6
 * @author ook
 *
 */

public class Test01 
{
	private final int step = 4;	//총 몇개의 도시를 지날것인지...
	private static int C = 0;
	private static int E = 0;
	private static int[][] path;
	private static int[] log;
	private static int nowStep = 0;
	
	@Test
	public void findWay()
	{
		for(int test_case=1; test_case<=1; test_case++)
		{
			Scanner sc = new Scanner(System.in);
			
			C = sc.nextInt();
			E = sc.nextInt();
			
			path = new int[C][C];
			
			for(int i=0; i<E; i++)
			{
				path[sc.nextInt()-1][sc.nextInt()-1] = 1;
			}
			
			log = new int[step];
			
			searchPath(0);
		}
	}
	
	public void searchPath(int row)
	{
		if(nowStep >= step-1)
		{
			log[nowStep] = row;
			for(int i=0; i<step; i++)
			{
				System.out.print((log[i]+1) + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<C; i++)
		{
			if(path[row][i] == 1)
			{
				log[nowStep] = row;
				
				nowStep++;
				searchPath(i);
				nowStep--;
			}
		}
	}
	
	//add some comments
}
