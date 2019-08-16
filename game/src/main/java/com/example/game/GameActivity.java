package com.example.game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    TextView txtP1, txtP2;
    ImageView imageView_11, imageView_12, imageView_13, imageView_14,
            imageView_21, imageView_22, imageView_23, imageView_24,
            imageView_31, imageView_32, imageView_33, imageView_34;

    Integer[] cards = {
            101, 102, 103, 104, 105, 106,
            201, 202, 203, 204, 205, 206
    };
    int image101, image102, image103, image104, image105, image106,
            image201, image202, image203, image204, image205, image206;

    int firstCard, secondCard;
    int firstClicked, secondClicked;
    int cardNumber = 1;
    int turn = 1;
    int player1Point = 0, player2Point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();

        txtP1 = findViewById(R.id.txtPlayer1);
        txtP2 = findViewById(R.id.txtPlayer2);

        imageView_11 = (ImageView) findViewById(R.id.image_11);
        imageView_12 = (ImageView) findViewById(R.id.image_12);
        imageView_13 = (ImageView) findViewById(R.id.image_13);
        imageView_14 = (ImageView) findViewById(R.id.image_14);
        imageView_21 = (ImageView) findViewById(R.id.image_21);
        imageView_22 = (ImageView) findViewById(R.id.image_22);
        imageView_23 = (ImageView) findViewById(R.id.image_23);
        imageView_24 = (ImageView) findViewById(R.id.image_24);
        imageView_31 = (ImageView) findViewById(R.id.image_31);
        imageView_32 = (ImageView) findViewById(R.id.image_32);
        imageView_33 = (ImageView) findViewById(R.id.image_33);
        imageView_34 = (ImageView) findViewById(R.id.image_34);

        imageView_11.setTag("0");
        imageView_12.setTag("1");
        imageView_13.setTag("2");
        imageView_14.setTag("3");
        imageView_21.setTag("4");
        imageView_22.setTag("5");
        imageView_23.setTag("6");
        imageView_24.setTag("7");
        imageView_31.setTag("8");
        imageView_32.setTag("9");
        imageView_33.setTag("10");
        imageView_34.setTag("11");

        //load cards
        loadImageCards();

        //shuffle cards
        Collections.shuffle(Arrays.asList(cards));

        txtP2.setTextColor(Color.GRAY);

        imageView_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_11, indexCard);
            }
        });

        imageView_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_12, indexCard);
            }
        });
        imageView_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_13, indexCard);
            }
        });
        imageView_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_14, indexCard);
            }
        });
        imageView_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_21, indexCard);
            }
        });
        imageView_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_22, indexCard);
            }
        });
        imageView_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_23, indexCard);
            }
        });
        imageView_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_24, indexCard);
            }
        });
        imageView_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_31, indexCard);
            }
        });
        imageView_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_32, indexCard);
            }
        });
        imageView_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_33, indexCard);
            }
        });
        imageView_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int indexCard = Integer.parseInt((String) view.getTag());
                doStuff(imageView_34, indexCard);
            }
        });

    }

    // set images for cards
    private void doStuff(ImageView imageView, int index) {
        if (cards[index] == 101) {
            imageView.setImageResource(image101);
        } else if (cards[index] == 102) {
            imageView.setImageResource(image102);
        } else if (cards[index] == 103) {
            imageView.setImageResource(image103);
        } else if (cards[index] == 104) {
            imageView.setImageResource(image104);
        } else if (cards[index] == 105) {
            imageView.setImageResource(image105);
        } else if (cards[index] == 106) {
            imageView.setImageResource(image106);
        } else if (cards[index] == 201) {
            imageView.setImageResource(image201);
        } else if (cards[index] == 202) {
            imageView.setImageResource(image202);
        } else if (cards[index] == 203) {
            imageView.setImageResource(image203);
        } else if (cards[index] == 204) {
            imageView.setImageResource(image204);
        } else if (cards[index] == 205) {
            imageView.setImageResource(image205);
        } else if (cards[index] == 206) {
            imageView.setImageResource(image206);
        }


        if (cardNumber == 1) { // first image clicked
            firstCard = cards[index];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            firstClicked = index;

            imageView.setEnabled(false);

        } else if (cardNumber == 2) { // second image clicked
            secondCard = cards[index];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            secondClicked = index;

            imageView_11.setEnabled(false);
            imageView_12.setEnabled(false);
            imageView_13.setEnabled(false);
            imageView_14.setEnabled(false);
            imageView_21.setEnabled(false);
            imageView_22.setEnabled(false);
            imageView_23.setEnabled(false);
            imageView_24.setEnabled(false);
            imageView_31.setEnabled(false);
            imageView_32.setEnabled(false);
            imageView_33.setEnabled(false);
            imageView_34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //check the same images
                    checkTheSameImage();
                }
            }, 1000);
        }

    }

    private void checkTheSameImage() {

        // check if fisrtCard == secondCard invisible cards
        if (firstCard == secondCard) {
            if (firstClicked == 0) {
                imageView_11.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 1) {
                imageView_12.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 2) {
                imageView_13.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 3) {
                imageView_14.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 4) {
                imageView_21.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 5) {
                imageView_22.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 6) {
                imageView_23.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 7) {
                imageView_24.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 8) {
                imageView_31.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 9) {
                imageView_32.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 10) {
                imageView_33.setVisibility(View.INVISIBLE);
            }
            if (firstClicked == 11) {
                imageView_34.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 0) {
                imageView_11.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 1) {
                imageView_12.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 2) {
                imageView_13.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 3) {
                imageView_14.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 4) {
                imageView_21.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 5) {
                imageView_22.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 6) {
                imageView_23.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 7) {
                imageView_24.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 8) {
                imageView_31.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 9) {
                imageView_32.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 10) {
                imageView_33.setVisibility(View.INVISIBLE);
            }
            if (secondClicked == 11) {
                imageView_34.setVisibility(View.INVISIBLE);
            }

            if (turn == 1) {
                player1Point++;
                txtP1.setText("Player 1: " + player1Point + "points");
            } else if (turn == 2) {
                player2Point++;
                txtP2.setText("Player 2: " + player2Point + "points");
            }
        } else {
            imageView_11.setImageResource(R.drawable.ic_question_mark);
            imageView_12.setImageResource(R.drawable.ic_question_mark);
            imageView_13.setImageResource(R.drawable.ic_question_mark);
            imageView_14.setImageResource(R.drawable.ic_question_mark);
            imageView_21.setImageResource(R.drawable.ic_question_mark);
            imageView_22.setImageResource(R.drawable.ic_question_mark);
            imageView_23.setImageResource(R.drawable.ic_question_mark);
            imageView_24.setImageResource(R.drawable.ic_question_mark);
            imageView_31.setImageResource(R.drawable.ic_question_mark);
            imageView_32.setImageResource(R.drawable.ic_question_mark);
            imageView_33.setImageResource(R.drawable.ic_question_mark);
            imageView_34.setImageResource(R.drawable.ic_question_mark);

            if (turn == 1) {
                turn = 2;
                txtP1.setTextColor(Color.GRAY);
                txtP2.setTextColor(Color.BLACK);
            } else if (turn == 2) {
                turn = 1;
                txtP1.setTextColor(Color.BLACK);
                txtP2.setTextColor(Color.GRAY);
            }
        }
        imageView_11.setEnabled(true);
        imageView_12.setEnabled(true);
        imageView_13.setEnabled(true);
        imageView_14.setEnabled(true);
        imageView_21.setEnabled(true);
        imageView_22.setEnabled(true);
        imageView_23.setEnabled(true);
        imageView_24.setEnabled(true);
        imageView_31.setEnabled(true);
        imageView_32.setEnabled(true);
        imageView_33.setEnabled(true);
        imageView_34.setEnabled(true);

        onGameOver();
    }

    private void onGameOver() {
        if (imageView_11.getVisibility() == View.INVISIBLE &&
                imageView_12.getVisibility() == View.INVISIBLE &&
                imageView_13.getVisibility() == View.INVISIBLE &&
                imageView_14.getVisibility() == View.INVISIBLE &&
                imageView_21.getVisibility() == View.INVISIBLE &&
                imageView_22.getVisibility() == View.INVISIBLE &&
                imageView_23.getVisibility() == View.INVISIBLE &&
                imageView_24.getVisibility() == View.INVISIBLE &&
                imageView_31.getVisibility() == View.INVISIBLE &&
                imageView_32.getVisibility() == View.INVISIBLE &&
                imageView_33.getVisibility() == View.INVISIBLE &&
                imageView_34.getVisibility() == View.INVISIBLE) {
            AlertDialog.Builder alert = new AlertDialog.Builder(GameActivity.this);
            alert.setMessage("GAME OVER!!!\n" +
                    "Player 1: " + player1Point + "points\n" +
                    "Player 2: " + player2Point + "points")
                    .setCancelable(false)
                    .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            GameActivity.this.finish();
                        }
                    })
                    .setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
            alert.create();
            alert.show();
        }
    }

    private void loadImageCards() {
        image101 = R.drawable.ic_image101;
        image102 = R.drawable.ic_image102;
        image103 = R.drawable.ic_image103;
        image104 = R.drawable.ic_image104;
        image105 = R.drawable.ic_image105;
        image106 = R.drawable.ic_image106;
        image201 = R.drawable.ic_image201;
        image202 = R.drawable.ic_image202;
        image203 = R.drawable.ic_image203;
        image204 = R.drawable.ic_image204;
        image205 = R.drawable.ic_image205;
        image206 = R.drawable.ic_image206;
    }

}
