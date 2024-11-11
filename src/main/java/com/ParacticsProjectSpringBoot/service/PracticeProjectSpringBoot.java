package com.ParacticsProjectSpringBoot.service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class PracticeProjectSpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(PracticeProjectSpringBoot.class, args);
		System.out.println("hello");

//print name's character and its frequency
/*

	String name="Niteshh";
		for(int i=0;i<name.length();i++){
			char val=name.charAt(i);
			int a=0;
			for(int j=0;j<name.length();j++){
				if(val==name.charAt(j)){
					a++;
				}
			}
			System.out.println(Character.toString(val)+a);
		}
		*/

//toggling the String and convert lower case latter in upper and same upper case latter in lower
/*
   if String contains spacial character keep as it is
		String toggle= "@TestInG@He12LLo";
		StringBuffer proToggle = new StringBuffer();

		for(int i =0; i<toggle.length();i++){
			char firstChar = toggle.charAt(i);
			if(firstChar >= 'A'&&firstChar <='Z'){
				proToggle.append(Character.toLowerCase(firstChar));
			}else if(firstChar >= 'a'&&firstChar <='z'){
				proToggle.append(Character.toUpperCase(firstChar));
			}else {
				proToggle.append(firstChar);
			}
		}
		System.out.println(proToggle);
 */

//== operator compares object references. and quals() method in the String class compares
/*
		String s1 ="Hello";
		String s2 ="Hello";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));

 output: true,true

ans:The == operator compares object references. Since s1 and s2 refer to the same object in the string pool, s1 == s2 evaluates to true.
    The equals() method in the String class compares the content of the strings.
Since both s1 and s2 have the same content ("Hello"), s1.equals(s2) returns true.


		String s1 = new String("Hello");
		String s2 = new String("Hello");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
        output: false,true
ans: s1 == s2: false because s1 and s2 are different objects in memory.
     s1.equals(s2): true because s1 and s2 have the same string content.

		 */

//find the last word length in the string
/*
		String lastWord = "Hello welcome in the new World ";
		int count =0;
		for(int i =lastWord.length()-1; i>0; i--){
			if(lastWord.charAt(i)!=' '){
				count++;
			}else if(count != 0){
				break;
			}
		}
		System.out.println(count);

 */

//remove duplicate key from stringValue
/*
 String value = "Hello";
	 LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
		for(char i:value.toCharArray()){
			linkedHashSet.add(i);
		}
		StringBuffer stringBuffer = new StringBuffer();
		System.out.println(linkedHashSet);
		Iterator<Character> iterator = linkedHashSet.iterator();
		while (iterator.hasNext()){
			Character next = iterator.next();
			stringBuffer.append(next);

		}
		System.out.println(stringBuffer);
*/

//Swipe name in String
/*
		String name = "Sunny Jaiswar";
        String nameArray[]= name.split(" ");
		String surname = nameArray[1];
		String firstName= nameArray[0];
		System.out.println(surname+" "+firstName);*/

//Bubble sorting
/*
		int[] array = { 23, 25, 22, 28, 30, 21 };
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
			}*/

// reverse String
/*
String reverse="Sunny Jaiswar";
System.out.println(reverse);
StringBuffer name=new StringBuffer();
for(int i = reverse.length()-1; i>=0;i--){
	char firstChar= reverse.charAt(i);
	name.append(firstChar);
}
	System.out.println(name);
*/

//Find the smallest and greatest number in array
/*		int array[] ={5,3,2,6,8,1};
        int smallest = array[1];
		for (int i=1;i< array.length;i++){
			if(array[i]<smallest){
			smallest=array[i];
			}

		}
		System.out.println(smallest);*/

//Remove duplicate from sorted array
/*
		int array[]={1,2,2,3,3,4,4,4,5};
		int arrays[] = new int[array.length];
		int j = 0;
		for(int i=0; i< array.length-1;i++){
			if(array[i]!=array[i+1]){
				arrays[j]=array[i];
				j++;
			}
			arrays[j]= array[array.length - 1];
		}
		for (int i = 0; i < j; i++) {
			System.out.print(arrays[i] + " ");
		}*/

//Get Distinct Characters and Their Count in a String
/*

		String words="HelloWorld";
		Map<Character,Integer> map = new HashMap<>();
		for(char value: words.toCharArray()){
			if(map.containsKey(value)){
				map.put(value,map.get(value)+1);
			}else {
				map.put(value,1);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
*/

//practices
/*Set<String>linkedHashSet = new TreeSet<>();
		linkedHashSet.add("Apple");
		linkedHashSet.add("11");
		linkedHashSet.add("apple");
		linkedHashSet.add("greps");
		linkedHashSet.add("banana");
		System.out.println(linkedHashSet);


		   String arra[] = new String[linkedHashSet.size()];
		   arra= linkedHashSet.toArray(arra);

		   for(String value:arra){
			System.out.println(value);
		    }

		String[] array = {"banana", "Apple", "grapes", "apple"};
		   Arrays.sort(array);*/
	}
}


