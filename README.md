# Mastermind

### __HOW TO RUN__

1. Java Compiler

        $ javac *.java -d .

2. Run the program with below cmd
   
        $ java mastermind.GuessNum

__OR__

outside dir

1. Java Compiler

        $ javac -cp . mastermind/*.java

2. Run the program with below cmd

        $ java -cp . mastermind.GuessNum

# Introduction

### __Information on the Mastermind__

The object of this game is to guess the sequence of `four` colored pegs the computer has selected at random from the circled colors ("Blue", "Green", "Orange", "Pink", "Red", "Yellow") in the playing area. `The colors may be repeated`.


### __Requirements__

Make sure you understand how to play the Mastermind game. For simplicity, we use the numeric digit to represent that color (i.e. 1 - "Blue", 2 - "Green", 3 - "Orange", 4 - "Purple", 5 - "Red", 6 - "Yellow"). 
Player1 or Computer will set secret pattern and Player2 tries to guess the pattern, in both order and color, within `ten` turns. 
Each guess is made by placing a row of code pegs on the decoding board. Once placed, player1 provides feedback by placing from zero to four key pegs in the small holes of the row with the guess. A `black` key peg is placed for each code peg from the guess which is correct in both color and position. A `white` peg indicates the existence of a correct color peg placed in the wrong position.


### __Functional Requirement__

Your program can play in two mode: `'Computer VS Player2'` or `'Player1 VS Player2'`.

__Computer VS Player__

Your program will automatically generate an answer for Player2 to guess.

__Player VS Player__

Your program will ask Player1 to input an answer and then Player2 starts to guess.

__Player2 starts to guess__

Your program shows a prompt and asks a player to input their guess.

The console will display the first guess with black and white result. If the result is not correct, the program will ask the player to input his/her second guess.

If the player’s guess is correct, your program indicates that the player wins.

The program will keep asking the player to input a guess and display the result until the guess is correct or the number of guesses reaches 10.
If the player cannot get the correct answer after his/her 10th guess, the game shows a message with answer indicating that the player loses the game.
If a game is finished, the program will ask players to continue to play another game or not.

Player2 is allowed to give up the game by input 0 in the guess and the computer will show he lose the game and give the answer.

### __Error Handling__

Your program must handle following errors:
For the Yes / No question, the program will use y or Y for Yes, n or N for No. If players do not follow this rule, prompt an error message and ask them to input again.

For the players input the answer or guess, the input value must be FOUR digits and each digit must be within the range 1 to 6.

### __Object Oriented Requirement on Error Handling__

You are required to use Object Oriented Programming Skill on Error Handling.

### __Testing__

You can ease the testing by using 'Copy and Paste' rather than inputting data manually. Prepare a text file, which includes all user inputs in a game run. The following input is an example. 

    abc
    a
    n
    abc
    12345
    578
    1237
    1123
    ab345
    457
    123
    12345
    2211
    2112
    1212
    1233
    1223
    1123
    a
    ab
    n
