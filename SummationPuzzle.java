import java.util.*;

public class SummationPuzzle {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String first = scan.next();
        System.out.println(" + ");
        String second = scan.next();
        System.out.println(" = ");
        String third = scan.next();
        sum(first, second, third);


    }

    public static void sum(String first, String second, String third) {
        Set<Character> unique = findUnique(first,second,third);
        ArrayList<String> list = sampleSpace(unique.toArray().length);

        char[] uniques = new char[unique.toArray().length];
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        for (char c: unique) {
            map.put(c, 0);
            uniques[i] = c; i++;
        }

        int summ = 0;
        int result = 0;
        int k = 0;
        for (String number: list) {
            i = 0;
            for (char c: number.toCharArray()) {
                map.replace(uniques[i], (c % 10 + 2) % 10);
                i++;
            }
            summ = 0;
            result = 0;
            k = 0;
            for (int j = first.length()-1; j >=0; j--) {
                summ += (int) Math.pow(10,j) * map.get(first.charAt(k));
                k++;
            }
            k = 0;
            for (int j = second.length()-1; j >=0; j--) {
                summ += (int) Math.pow(10,j) * map.get(second.charAt(k));
                k++;
            }
            k = 0;
            for (int j = third.length()-1; j >=0; j--) {
                result += (int) Math.pow(10,j) * map.get(third.charAt(k));
                k++;
            }
            if(summ == result){
                System.out.println(map);
                String summationPuzzleAnswer = "";
                for (int j = 0; j < first.length(); j++) {
                    summationPuzzleAnswer = summationPuzzleAnswer.concat(map.get(first.charAt(j)).toString());
                }
                summationPuzzleAnswer = summationPuzzleAnswer.concat(" + ");
                for (int j = 0; j < second.length(); j++) {
                    summationPuzzleAnswer = summationPuzzleAnswer.concat(map.get(second.charAt(j)).toString());
                }
                summationPuzzleAnswer = summationPuzzleAnswer.concat(" = ");
                for (int j = 0; j < third.length(); j++) {
                    summationPuzzleAnswer = summationPuzzleAnswer.concat(map.get(third.charAt(j)).toString());
                }
                System.out.println(summationPuzzleAnswer + "\n");
            }
        }

    }

    // Arrays unique characters in strings entered as parameters
    public static Set<Character> findUnique(String first, String second, String third) {
        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();
        char[] chars3 = third.toCharArray();
        Set<Character> unique = new HashSet<>();
        for (char c: chars1)
            unique.add(c);
        for (char c: chars2)
            unique.add(c);
        for (char c: chars3)
            unique.add(c);
        return unique;
    }


    // Generates parameter-length numbers with different digits in themselves
    public static ArrayList<String> sampleSpace (int length) {
        ArrayList<String> list = new ArrayList<>();
        String[] digits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        String number = "";
        for (int i = 0; i < 10; i++) {
            number = "";
            number = number.concat(digits[i]);
            if (length<2) list.add(number);

            for (int j = 0; j < 10; j++) {
                if (length < 2) break;
                number = number.substring(0,1);
                if (number.contains(digits[j])) continue;
                number = number.concat(digits[j]);
                if (length<3) {
                    list.add(number);
                    number = number.substring(0,number.length()-1);
                }

                for (int k = 0; k < 10; k++) {
                    if (length < 3) break;
                    number = number.substring(0,2);
                    if (number.contains(digits[k])) continue;
                    number = number.concat(digits[k]);
                    if (length<4) {
                        list.add(number);
                        number = number.substring(0,number.length()-1);
                    }

                    for (int l = 0; l < 10; l++) {
                        if (length < 4) break;
                        number = number.substring(0,3);
                        if (number.contains(digits[l])) continue;
                        number = number.concat(digits[l]);
                        if (length<5) {
                            list.add(number);
                            number = number.substring(0,number.length()-1);
                        }

                        for (int m = 0; m < 10; m++) {
                            if (length < 5) break;
                            number = number.substring(0,4);
                            if (number.contains(digits[m])) continue;
                            number = number.concat(digits[m]);
                            if (length<6) {
                                list.add(number);
                                number = number.substring(0,number.length()-1);
                            }

                            for (int n = 0; n < 10; n++) {
                                if (length < 6) break;
                                number = number.substring(0,5);
                                if (number.contains(digits[n])) continue;
                                number = number.concat(digits[n]);
                                if (length<7) {
                                    list.add(number);
                                    number = number.substring(0,number.length()-1);
                                }

                                for (int o = 0; o < 10; o++) {
                                    if (length < 7) break;
                                    number = number.substring(0,6);
                                    if (number.contains(digits[o])) continue;
                                    number = number.concat(digits[o]);
                                    if (length<8) {
                                        list.add(number);
                                        number = number.substring(0,number.length()-1);
                                    }

                                    for (int p = 0; p < 10; p++) {
                                        if (length < 8) break;
                                        number = number.substring(0,7);
                                        if (number.contains(digits[p])) continue;
                                        number = number.concat(digits[p]);
                                        if (length<9) {
                                            list.add(number);
                                            number = number.substring(0,number.length()-1);
                                        }

                                        for (int q = 0; q < 10; q++) {
                                            if (length < 9) break;
                                            number = number.substring(0,8);
                                            if (number.contains(digits[q])) continue;
                                            number = number.concat(digits[q]);
                                            if (length<10) {
                                                list.add(number);
                                                number = number.substring(0,number.length()-1);
                                            }

                                            for (int r = 0; r < 10; r++) {
                                                if (length < 10) break;
                                                if (number.contains(digits[r])) continue;
                                                number = number.concat(digits[r]);
                                                list.add(number);
                                                number = number.substring(0,number.length()-1);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
}


