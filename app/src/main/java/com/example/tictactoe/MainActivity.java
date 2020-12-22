package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView winmsg = findViewById(R.id.winnerMessage);
        winmsg.setTextColor(Color.BLACK);
        winmsg.setText("Player 1 turn!");

        Button playagain = (Button) findViewById(R.id.button);
        playagain.setVisibility(View.INVISIBLE);
    }
    int board[][] ={{-1,-1,-1},
                    {-1,-1,-1},
                    {-1,-1,-1}};
    private Handler handler;

    ImageView[][] IV = new ImageView[3][3];

    boolean gameWon =false;

    // first chance will be of player 1 which will be X

    // for player 1 : board score will be 1
    // for player 2: board score will be 0

    int count=1;

    public void decideXO(int i, int j, ImageView anyposition){

        TextView winmsg = findViewById(R.id.winnerMessage);
        if(count<=9 && count%2==0){
            // player 2 having O
            anyposition.setImageResource(R.drawable.circlering);
            board[i][j]=0;
            winmsg.setText("Player 1 turn!");
        }
        // player 1 having X
        else if(count<=9 && count%2!=0)
            {
            anyposition.setImageResource(R.drawable.cancel);
            board[i][j]=1;
            winmsg.setText("Player 2 turn!");
        }
        count++;
    }


    private void showButton() {

        final Button btn = (Button) findViewById(R.id.button);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                btn.setBackgroundColor(Color.RED);
                btn.setTextColor(Color.WHITE);
                btn.setVisibility(View.VISIBLE);
            }
        }, 300);}

        private void showText(final String s){
        final TextView winmsg = findViewById(R.id.winnerMessage);
        winmsg.setVisibility(View.INVISIBLE);
            handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    winmsg.setText(s);
                    winmsg.setTextColor(Color.WHITE);
                    winmsg.setVisibility(View.VISIBLE);
                }
            }, 300);}

    public boolean checkwin(){


        if((board[0][0]==1&& board[0][1]==1&& board[0][2]==1)||
            (board[1][0]==1&&board[1][1]==1&&board[1][2]==1)||
            (board[2][0]==1&& board[2][1]==1&& board[2][2] ==1)
                        || (board[0][0]==1 && board[1][0]==1 && board[2][0]==1)||
                            (board[0][1]==1&& board[1][1]==1 && board[2][1]==1)|| (board[0][2]==1 && board[1][2]==1 && board[2][2]==1)
        || (board[0][0]==1&& board[1][1]==1&&board[2][2]==1) || (board[0][2]==1 && board[1][1]==1 && board[2][0]==1))

        {
            // player 1 wins the game
              gameWon=true;
              showText("Player 1 wins the game!");
              showButton();
              return true;
        }

        else if((board[0][0]==0&& board[0][1]==0&& board[0][2]==0)||
                (board[1][0]==0&&board[1][1]==0&&board[1][2]==0)||
                (board[2][0]==0&& board[2][1]==0&& board[2][2] ==0)
                || (board[0][0]==0 && board[1][0]==0 && board[2][0]==0)||
                (board[0][1]==0&& board[1][1]==0 && board[2][1]==0)|| (board[0][2]==0 && board[1][2]==0 && board[2][2]==0)
                || (board[0][0]==0&& board[1][1]==0&&board[2][2]==0) || (board[0][2]==0 && board[1][1]==0 && board[2][0]==0)){

            // Player 2 wins the game
            gameWon=true;
            showText("Player 2 wins the game!");
            showButton();

            return true;

        }
        else if(board[0][0]!=-1 && board[0][1]!=-1 && board[0][2]!=-1
            &&  board[1][0]!=-1 && board[1][1]!=-1 && board[1][2]!=-1
            &&  board[2][0]!=-1 && board[2][1]!=-1 && board[2][2]!=-1){

            gameWon =false;
            showText("Game Over!");
            showButton();
        }
        return false;

    }

    public void playagain(View view){

        gameWon=false;
        count=1;

        Button playAgainButton = (Button) findViewById(R.id.button);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerMessage);
        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setText("Player 1 turn!");


        winnerTextView.setTextColor(Color.BLACK);

        for(int i=0; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j]==0||board[i][j]==1){
                    board[i][j]=-1;
                    IV[i][j].setImageDrawable(null);
                }
            }
        }

    }

    public void clickone(View view){

         IV[0][0] = (ImageView)view;

        if(board[0][0]==1 || board[0][0]==0 || gameWon ==true){
         return;
        }

        IV[0][0].setTranslationY(-1500);
        decideXO(0, 0,  IV[0][0]);
        IV[0][0].animate().translationYBy(1500).setDuration(300);
        checkwin();

    }


    public void clicktwo(View view){

        IV[0][1] = (ImageView) view;
        if(board[0][1]==1 || board[0][1]==0 || gameWon ==true){
            return;
        }
        IV[0][1] .setTranslationY(-1500);
        decideXO(0, 1,  IV[0][1] );
        IV[0][1] .animate().translationYBy(1500).setDuration(300);
        checkwin();
    }

    public void clickthree(View view){
        IV[0][2]  =(ImageView)  view;
        if(board[0][2]==1 || board[0][2]==0 || gameWon ==true){
            return;
        }
        IV[0][2] .setTranslationY(-1500);
        decideXO(0, 2,  IV[0][2]);
        IV[0][2] .animate().translationYBy(1500).setDuration(300);

        checkwin();
    }

    public void clickfour(View view){
        IV[1][0]  = (ImageView)view;
        if(board[1][0]==1 || board[1][0]==0 || gameWon ==true){
            return;
        }
        IV[1][0] .setTranslationY(-1500);
        decideXO(1, 0,  IV[1][0] );
        IV[1][0] .animate().translationYBy(1500).setDuration(300);

        checkwin();
    }

    public void clickfive(View view){
        IV[1][1]  = (ImageView) view;
        if(board[1][1]==1 || board[1][1]==0 || gameWon ==true){
            return;
        }
        IV[1][1] .setTranslationY(-1500);
        decideXO(1, 1,   IV[1][1] );
        IV[1][1] .animate().translationYBy(1500).setDuration(300);

        checkwin();

    }

    public void clicksix(View view){
        IV[1][2]  = (ImageView) view;
        if(board[1][2]==1 || board[1][2]==0 || gameWon ==true){
            return;
        }
        IV[1][2].setTranslationY(-1500);
        decideXO(1, 2, IV[1][2]);
        IV[1][2].animate().translationYBy(1500).setDuration(300);
        checkwin();
    }

    public void clickseven(View view){
        IV[2][0] = (ImageView)view;
        if(board[2][0]==1 || board[2][0]==0 || gameWon ==true){
            return;
        }
        IV[2][0].setTranslationY(-1500);
        decideXO(2, 0, IV[2][0]);
        IV[2][0].animate().translationYBy(1500).setDuration(300);
        checkwin();
    }

    public void clickeight(View view){
        IV[2][1] =(ImageView)  view;
        if(board[2][1]==1 || board[2][1]==0 || gameWon ==true){
            return;
        }
        IV[2][1].setTranslationY(-1500);
        decideXO(2, 1, IV[2][1]);
        IV[2][1].animate().translationYBy(1500).setDuration(300);
        checkwin();
    }

    public void clicknine(View view){
        IV[2][2] = (ImageView) view;
        if(board[2][2]==1 || board[2][2]==0 || gameWon ==true){
            return;
        }
        IV[2][2] .setTranslationY(-1500);
        decideXO(2, 2, IV[2][2]);
        IV[2][2] .animate().translationYBy(1500).setDuration(300);
        checkwin();
    }
}