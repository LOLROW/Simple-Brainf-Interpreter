import java.util.*;

public class Main {
    public static void main(String [] Args) {
        int[] memory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // Creates memory.
        Scanner keyboard = new Scanner(System.in);
        int memoryState = memory[0]; // Creates position variable within memory.
        System.out.println(Arrays.toString(memory));
        while (true) {
            String command = keyboard.nextLine();
            System.out.print("\033[H\033[2J");
            if ("+".equals(command)) {
                memory[memoryState] += 1;
                System.out.println(Arrays.toString(memory));
            }
            else if ("-".equals(command)) {
                memory[memoryState] -= 1;
                System.out.println(Arrays.toString(memory));
            }
            else if (">".equals(command)) {
                memoryState += 1;
                System.out.println(Arrays.toString(memory));
            }
            else if ("<".equals(command)) {
                memoryState -= 1;
                System.out.println(Arrays.toString(memory));
            }
            else if (".".equals(command)) {
                System.out.println(Character.toChars(memory[memoryState]));
                System.out.println(Arrays.toString(memory));
            }
            else if (",".equals(command)) {
                char input = keyboard.nextLine().charAt(0);
                String a = Integer.toHexString(input);
                int conv = Integer.parseInt(a);
                memory[memoryState] += conv;
                System.out.println(Arrays.toString(memory));
            }
            else if ("[".equals(command)) {
                int memoryStateSave = memoryState; // Create save in memory position before starting loop.
                System.out.println(memoryStateSave);
                String loopCommand = keyboard.nextLine(); // Take in command to run inside loop. For Example <+++++++++>-
                boolean finished = false; // Initialize escape variable.
                while (!finished) {
                    for (char i : loopCommand.toCharArray()) { // Start loop which runs through every letter.
                        if (memory[memoryStateSave] == 0) { // Check if memory position before looping is 0.
                            finished = true;
                        } else { // Start executing commands.
                            if (i == '+') {
                                memory[memoryState] += 1;
                                System.out.println(Arrays.toString(memory));
                            } else if (i == '-') {
                                memory[memoryState] -= 1;
                                System.out.println(Arrays.toString(memory));
                            } else if (i == '>') {
                                memoryState += 1;
                                System.out.println(Arrays.toString(memory));
                            } else if (i == '<') {
                                memoryState -= 1;
                                System.out.println(Arrays.toString(memory));
                            } else if (i == '.') {
                                System.out.println(Character.toChars(memory[memoryState]));
                                System.out.println(Arrays.toString(memory));
                            } else if (i == ',') {
                                char input = keyboard.nextLine().charAt(0);
                                String a = Integer.toHexString(input);
                                int conv = Integer.parseInt(a);
                                memory[memoryState] += conv;
                                System.out.println(Arrays.toString(memory));
                            }
                        }
                    }
                }
            }
        }
    }
}
