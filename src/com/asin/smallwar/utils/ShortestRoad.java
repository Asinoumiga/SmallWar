package com.asin.smallwar.utils;

import com.asin.smallwar.common.Constance;
import com.asin.smallwar.soldiers.Position;

import java.util.*;

/*
 * like 
 * [[0,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,0,0,0,0],
 * [0,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,1,0,0,0,0,0]]
 * from left to right
 * 
 */
public class ShortestRoad {
	public static Position getRoad(int[][] map, Position nowLocation, List<Position> enemys){
		int xLength = map[0].length;
		int yLength = map.length;
		System.out.println("xLength:"+xLength);
		System.out.println("yLength:"+yLength);
		List<Position> visited = new ArrayList<>();
		Queue<Position> queue = new LinkedList<>();
		List<Position> solutions = new ArrayList<>();
		queue.add(nowLocation);
		boolean isNeedLeft=true;
		boolean isNeedRight=true;
		if(nowLocation.getX()< Constance.VALID_X/Constance.MAP_GAP){
			isNeedLeft=false;
		}
		if(nowLocation.getX()> xLength-Constance.VALID_X/Constance.MAP_GAP){
			isNeedRight=false;
		}
		int nowRange = 0;
		while (!queue.isEmpty()&&solutions.isEmpty()){
			int size = queue.size();
			for (int i=0;i<size;i++){
				Position position = queue.poll();
				if(map[position.getY()][position.getX()]==1||visited.contains(position)){
					continue;
				}
//				System.out.println("nowRange: "+nowRange+"===="+position);
				if(enemys.contains(position)){
					solutions.add(position);
					continue;
				}
				visited.add(position);
				List<Position> positionList = getNearPositionWithBackWard(xLength,yLength,position,isNeedLeft,isNeedRight);
				for(Position pos:positionList){
					queue.offer(pos);
				}
			}
			nowRange++;
		}
		if (solutions.isEmpty()){
			return null;
		}else{
			return solutions.get((int)(Math.random()*solutions.size()));
		}
    }

/*
direction:

	7	0	1
	6	@	2
	5	4	3

先上下左右进行BFS，尽量避免侧向走
 */
	public static List<Position> getNearPositionWithBackWard(int xLength,int yLength,Position location,boolean isNeedLeft,boolean isNeedRight){
		List<Position> positions = new ArrayList<>();
		int x = location.getX();
		int y = location.getY();
		boolean xLarger0 = location.getX()>0;
		boolean xSmallermax = location.getX()<xLength-1;
		boolean yLarger0 = location.getY()>0;
		boolean ySmallermax = location.getY()<yLength-1;

		if(yLarger0){
			Position up = new Position(location.getX(), location.getY()-1);
			up.setDirect(0);
			up.setPrePosition(location);
			positions.add(up);
		}

		if(isNeedRight&&xSmallermax){
			Position right = new Position(location.getX()+1, location.getY());
			right.setDirect(2);
			right.setPrePosition(location);
			positions.add(right);
		}

		if(ySmallermax){
			Position down = new Position(location.getX(), location.getY()+1);
			down.setDirect(4);
			down.setPrePosition(location);
			positions.add(down);
		}

		if(isNeedLeft&&xLarger0){
			Position left = new Position(location.getX()-1, location.getY());
			left.setDirect(6);
			left.setPrePosition(location);
			positions.add(left);
		}

		if(isNeedRight){
			if(xSmallermax&&yLarger0){
				Position upRight = new Position(location.getX()+1, location.getY()-1);
				upRight.setDirect(1);
				upRight.setPrePosition(location);
				positions.add(upRight);
			}

			if(xSmallermax&&ySmallermax){
				Position downRight = new Position(location.getX()+1, location.getY()+1);
				downRight.setDirect(3);
				downRight.setPrePosition(location);
				positions.add(downRight);
			}
		}

		if(isNeedLeft){
			if(xLarger0&&ySmallermax){
				Position downLeft = new Position(location.getX()-1, location.getY()+1);
				downLeft.setDirect(5);
				downLeft.setPrePosition(location);
				positions.add(downLeft);
			}

			if(xLarger0&&yLarger0){
				Position upLeft = new Position(location.getX()-1, location.getY()-1);
				upLeft.setDirect(7);
				upLeft.setPrePosition(location);
				positions.add(upLeft);
			}
		}

		return positions;
	}


	public static Stack<Position> getPositonStack(Position position){
		Stack<Position> stack = new Stack();
		stack.push(position);
		Integer direct = position.getDirect();
		while (position!=null){
			if(direct!=position.getDirect()&&position.getDirect()!=null){
				stack.push(position);
				direct = position.getDirect();
			}
//			System.out.println(position.toString()+position.getDirect());
			position = position.getPrePosition();
		}
		return stack;
	}

	public static void main(String[] args) {
//        int[][] map = new int[100][11];
//        map[0]=new int[]{0,0,0,0,0,0,0,0,0,0,0};
//        for(int i=1;i<100;i++){
//            map[i]=new int[]{0,0,0,0,0,1,0,0,0,0,0};
//        }
		int[][] map = MapLoader.getLittleMap("D:\\java\\workspace\\SmallWar\\src\\com\\asin\\smallwar\\utils\\map1.jpg");
//				{{0,0,0,0,0,1,0,0,0,0,0},
//				{0,0,0,0,0,1,0,0,0,0,0},
//				{0,0,0,1,1,1,0,0,1,0,0},
//				{0,1,0,0,0,1,0,0,1,0,0},
//				{0,0,1,1,1,1,0,0,0,0,0},
//				{0,0,0,0,0,0,0,0,1,0,0},
//				{0,0,0,0,0,1,0,0,1,0,0},
//				{0,0,1,0,0,1,1,0,0,0,0},
//				{0,0,0,0,1,0,0,0,0,0,0}};
		Position nowPosition = new Position(0,20);
		List<Position> enemys = new ArrayList<>();
		enemys.add(new Position(59,1));
		enemys.add(new Position(59,39));
		enemys.add(new Position(59,20));

//        enemys.add(new Position(3,2));
		ShortestRoad shortestRoad = new ShortestRoad();
		Position position = shortestRoad.getRoad(map,nowPosition,enemys);
		Stack<Position> stack = shortestRoad.getPositonStack(position);
		System.out.println("===========================");
		while (!stack.isEmpty()){
			Position pos = stack.pop();
			System.out.println(pos.toString()+pos.getDirect());
		}
	}
}
