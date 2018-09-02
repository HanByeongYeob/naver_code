import java.util.*;

import javax.script.*;

public class Brackets_test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;
		num = scanner.nextInt();
		for(int idx = 0; idx<num; idx++)
		{
			String temp = scanner.next();
			
			if(temp.length()<10001) {
				int tempf;
				int result;
				tempf = f(temp);
				result = tempf%100000000;
				System.out.println(result);
			}
		}
		scanner.close();
	}
	public static int f(String in) {
		int result = -1;
		String calresult = "";
		Stack<String> stack = new Stack<String>();
			if(in.length()%2 == 1) {
				result = 0;
			}else {
				ArrayList<String> array = new ArrayList<String>();
				String compare;
			
				for(int i = 0; i <in.length(); i++) {
					String temp = String.valueOf(in.charAt(i));
					array.add(temp);
				}
			
				for(int j = 0 ; j <array.size(); j++) {
					switch(array.get(j)) {
					case "(":
						stack.push("(");
						if(j == 0) {
							calresult += "(1";
						}else {
							if(array.get(j-1).equals(")") || array.get(j-1).equals("}") || array.get(j-1).equals("]")) {
								calresult += "+(1";
							}else if(array.get(j-1).equals("(") || array.get(j-1).equals("{") || array.get(j-1).equals("[")) {
								calresult += "*((1";
							}
							else {
								calresult += "(1";
							}
						}
						break;
					case "{":
						stack.push("{");
						if(j == 0) {
							calresult += "(2";
						}else {
							if(array.get(j-1).equals(")") || array.get(j-1).equals("}") || array.get(j-1).equals("]")) {
								calresult += "+(2";
							}else if(array.get(j-1).equals("(") || array.get(j-1).equals("{") || array.get(j-1).equals("[")) {
								calresult += "*((2";
							}else {
								calresult += "(2";
							}
						}
						break;
					case "[":
						stack.push("[");
						if(j == 0) {
							calresult += "(3";
						}else {
							if(array.get(j-1).equals(")") || array.get(j-1).equals("}") || array.get(j-1).equals("]")) {
								calresult += "+(3";
							}else if(array.get(j-1).equals("(") || array.get(j-1).equals("{") || array.get(j-1).equals("[")) {
								calresult += "*((3";
							}else {
								calresult += "(3";
							}
						}
						break;
					case ")":
						compare = stack.pop();
						if(!compare.equals("(")){
							result = 0;
							break;
						}else {
							if(array.get(j-1).equals(")") || array.get(j-1).equals("}") || array.get(j-1).equals("]"))
								calresult += "))";
							else
								calresult += ")";
							break;
						}
					case "}":
						compare = stack.pop();
						if(!compare.equals("{")){
							result = 0;
							break;
						}else {
							if(array.get(j-1).equals(")") || array.get(j-1).equals("}") || array.get(j-1).equals("]"))
								calresult += "))";
							else
								calresult += ")";
							break;
						}
					case "]":
						compare = stack.pop();
						if(!compare.equals("[")){
							result = 0;
							break;
						}else {
							if(array.get(j-1).equals(")") || array.get(j-1).equals("}") || array.get(j-1).equals("]"))
								calresult += "))";
							else
								calresult += ")";
							break;
						}
					}
				}
			}
			if (!stack.isEmpty()) {
				result = 0;
			}else {
		
				if(result != 0) {
					ScriptEngineManager segm = new ScriptEngineManager();
					ScriptEngine engine = segm.getEngineByName("JavaScript");
					try {
						result = (int)engine.eval(calresult);
					} catch (ScriptException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						result = 0;
					}
				}
			}
			
			return result;
	}
}
