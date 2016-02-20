package com.dlopatin.hashcode.y2016;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class Droids {

	private final static String FILE_IN = "input.txt";
	private final static String FILE_OUT = "output.txt";

	public static void main(String[] args) throws Exception {
		new Droids().doJob();

	}

	private void doJob() throws Exception {
		try (Scanner scanner = new Scanner(getInput())) {
			int rows = scanner.nextInt();
			int cols = scanner.nextInt();
			int dronesNumber = scanner.nextInt();
			int T = scanner.nextInt();
			int droneMaxLoad = scanner.nextInt();
			int productTypes = scanner.nextInt();
			int[] productWeight = new int[productTypes];
			for (int i = 0; i < productTypes; i++) {
				productWeight[i] = scanner.nextInt();
			}
			int warehousesNumber = scanner.nextInt();
			int[][] warehouseLocation = new int[warehousesNumber][2];
			int[] warehouseProducts = new int[productTypes];
			Map<Integer, Set<Integer>> productWarehousesMap = new HashMap<>();
			for (int i = 0; i < warehousesNumber; i++) {
				for (int j = 0; j < 2; j++) {
					warehouseLocation[i][j] = scanner.nextInt();
				}
				for (int j = 0; j < productTypes; j++) {
					int productNumber = scanner.nextInt();
					warehouseProducts[j] = productNumber;
					if (productNumber != 0) {
						Set<Integer> productWarehouses = productWarehousesMap.get(j);
						if (null == productWarehouses) {
							productWarehouses = new HashSet<>();
							productWarehousesMap.put(j, productWarehouses);
						}
						productWarehouses.add(i);

					}
				}
			}
			int ordersNumber = scanner.nextInt();
			int[][] orderLocation = new int[ordersNumber][2];
			List<List<Integer>> orderTypes = new ArrayList<>();
			for (int i = 0; i < ordersNumber; i++) {
				for (int j = 0; j < 2; j++) {
					orderLocation[i][j] = scanner.nextInt();
				}
				int orderItemsNumber = scanner.nextInt();
				List<Integer> orderItems = new ArrayList<>();
				for (int j = 0; j < orderItemsNumber; j++) {
					orderItems.add(scanner.nextInt());
				}
				orderTypes.add(orderItems);
			}

			List<Integer> items = orderTypes.get(0);
			Map<Integer, Integer> orderCnt = new HashMap<>();
			for (int prod : items) {
				int cnt = orderCnt.containsKey(prod) ? orderCnt.get(prod) + 1 : 0;
				orderCnt.put(prod, cnt);
			}

		}
	}

	private int distance(int[] a, int[] b) {
		return (int) Math.ceil(Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2)));
	}

	private File getInput() {
		return new File(getCurrentPath(FILE_IN));
	}

	private void writeFile(StringBuilder res, String file) throws IOException {
		String path = getCurrentPath(file);
		FileUtils.write(new File(path), res.toString().trim());
	}

	private String getCurrentPath(String file) {
		String packagePath = this.getClass().getPackage().getName().replace(".", File.separator);
		return "src/main/java" + File.separator + packagePath + File.separator + file;
	}

	private void writeOutput(StringBuilder res) throws IOException {
		writeFile(res, FILE_OUT);
	}

	private void printResult(StringBuilder res, int caseIdx, int val) {
		res.append(String.format("Case #%d: %d\n", caseIdx + 1, val));
	}

}
