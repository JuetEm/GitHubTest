import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFilter {

	public CsvFilter() {
		// TODO Auto-generated constructor stub
	}
	
	BufferedReader br;
	File file;
	FileReader fr;
	BufferedWriter bw;
	FileWriter fw;
	
	String GitTest = "Git Hub Test";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CsvFilter c = new CsvFilter();
		float matrix[][] = new float[100][5];
		
		String line = "";
		int row = 0, i;
		String path = "C:\\Users\\esadmin\\Desktop\\ProjectKwon\\test1.csv";
		try {
			c.fw = new FileWriter(path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c.bw = new BufferedWriter(c.fw);
		
		List<String> csvRow = new ArrayList<String>();
		List<String> categorizedSubjList;
		String support = "Socail Support";
		String phobiac = "Phobiac";
		String exp = "Experience";
		String perc = "Perception";
		String FI = "Family Issue";
		
		c.getVariables();

		c.file =new File("C:\\Users\\esadmin\\Desktop\\ProjectKwon\\���������� ����.csv");
		try {
			c.br = new BufferedReader(new FileReader(c.file));
			while((line = c.br.readLine()) != null) {
				String token[] = line.split("\\|", -1);
				String lineLowerCase = line.toLowerCase();
//				c.categorizeSubject(line);
//				System.out.println(line);
//				if(!line.equals(",,,,,")) {
//					for(int k=0; k<5; k++) {
////						System.out.println(k+". token : "+token[k]);
//						if(!"".equals(token[k])) {
//							
//				for(int j=0; j<5; j++) {
//					System.out.println(j+". token["+j+"] : "+token[j]);
//				}
							if(token[4].contains("Welfare")|token[4].contains("Social Work")|token[4].contains("Social?Work")) {
//								matrix[row][k] = Float.parseFloat(token[k]);
//								System.out.println(matrix[row][k]);
//								System.out.println("selected line : "+line);
//								System.out.println("LowerCased line : "+line.toLowerCase());
								String csvLine = "";
								for(int k=0; k<5; k++) {
//									System.out.println("token["+k+"]"+token[k]);
									csvLine += token[k]+"|";
									if(!"".equals(token[k])) {
//										matrix[row][k] = Float.parseFloat(token[k]);
									}
								}
//								System.out.println("csvLine : "+csvLine);
								csvRow.add(csvLine);
								c.writeCSV( csvLine);
							}
							categorizedSubjList = c.categorizeSubject(line);
							
//						}
//					}
//				}
				
				row++;
			}
//			System.out.println(categorizedSubjList.get(row));
			c.br.close();
			c.bw.flush();
			c.bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeCSV(String txt) {
		try {
//			fw = new FileWriter(path);
//			bw = new BufferedWriter(fw);
			bw.write(txt);
			bw.newLine();
//			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List categorizeSubject(String str) {
//		System.out.println("�޼��� ���� Ȯ�� : "+str);
		String token[] = str.split("\\|", -1);
		String lowering = str.toLowerCase();
		
		List<String> checkedList = new ArrayList<String>();
		if(lowering.contains("education\\|school\\|education\\|schooling"
				+ "\\|student\\|teaching\\|TEACHING\\|practice\\|affirmative\\|affirming"
				+ "\\|Care\\|Life\\|Planning\\|Family\\|Therapy\\|Out-of-Home\\|Empowerment"
				+ "\\|Home\\|counseling\\|Therapy\\|suicidal\\|obstacle")) {
			System.out.println("���Խ� �Դ´�");
		}else if(lowering.contains("education")) {
			System.out.println("sopport filtering : "+str);
			checkedList.add(str);
		}
		return checkedList;
	}
	
	public void getVariables() {
		File variable = new File("C:\\Users\\esadmin\\Desktop\\ProjectKwon\\����.csv");
		FileReader fr;
		String[][] matrix = new String[50][50];
		try {
			fr = new FileReader(variable);
			BufferedReader br1 = new BufferedReader(fr);
			String line="";
			int vRow = 0;
			while((line=br1.readLine())!= null) {
				System.out.println(vRow+". ���� line : "+line);
				String[] tokenV = line.split("\\|",-1);
				System.out.println(vRow+". tokenV length : "+line.split("\\|", -1).length);
				int lengthCheck=0;
				int l=0;
				while(!"".equals(tokenV[l])) {
//					matrix[vRow][l] = tokenV[l];
					System.out.println("before lengthCheck : "+lengthCheck+"\n'L' value : "+l+"\ntoken["+l+"] : "+tokenV[l]);

					l++;
					lengthCheck++;
					try {
						if(true) {
							String k = tokenV[l];
						}
					}catch(ArrayIndexOutOfBoundsException e) {
						break;
					}
					System.out.println("after lengthCheck : "+lengthCheck+"\n'L' value : "+l);
				}
				for(int i = 0; i<lengthCheck; i++) {
					matrix[vRow][i] = tokenV[i];
					System.out.println("2�����迭 Ȯ�� : matrix["+vRow+"]["+i+"] - "+matrix[vRow][i]);
				}
				
				vRow++;
			}
			br1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
