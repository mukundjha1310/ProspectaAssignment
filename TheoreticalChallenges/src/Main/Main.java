package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		System.out.println();
		
		BufferedReader br = null;
		
		String path = "C:/Users/mukun/Desktop/A1.csv";
		
		String file = "";
		
		try 
		{
			br = new BufferedReader(new FileReader(path));
			
			while((file = br.readLine()) != null)
			{
				String[] strArray = file.split(", ");
				
				Map<String, Integer> map = new LinkedHashMap<>();
				
				for(String s:strArray)
				{
					String[] el = s.split(": "); //a1,5 //b3,=4+5
					
					int value = 0;
					
					try 
					{
						value = Integer.parseInt(el[1]);
					} catch (NumberFormatException e1) {
						
						String nums0 = el[1].substring(1);
						
						String[] nums = nums0.split("\\+");
						
						try {
							value += Integer.parseInt(nums[0]);
						} catch (NumberFormatException e2) {
							value += map.get(nums[0]);
						}
						
						try 
						{
							value += Integer.parseInt(nums[1]);
						} catch (NumberFormatException e3) {
							value += map.get(nums[1]);
						}
					}
					
					map.put(el[0], value);
				}
				
				System.out.println(map);
				
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally
		{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
