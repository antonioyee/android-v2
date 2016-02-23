package mx.antonioyee.soccergamefragment;

import android.graphics.ImageFormat;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class StadiumActivity extends AppCompatActivity implements PlayerFragment.PlayerChat {

    private FragmentManager dt;
    private int blue, yellow;
    private TextView txtScoreBlue, txtScoreYellow;
    private int scoreBlue, scoreYellow, position;
    private String positionStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);

        if ( savedInstanceState != null ){
            this.scoreBlue = savedInstanceState.getInt("scoreBlue");
            this.scoreYellow = savedInstanceState.getInt("scoreYellow");
            this.positionStr = savedInstanceState.getString("position");
            this.position = Integer.parseInt(positionStr);
        }

        this.blue = getResources().getColor(R.color.blue);
        this.yellow = getResources().getColor(R.color.yellow);

        this.dt = getSupportFragmentManager();

        txtScoreBlue = (TextView) findViewById(R.id.txtScoreBlue);
        txtScoreYellow = (TextView) findViewById(R.id.txtScoreYellow);

        txtScoreBlue.setText(String.valueOf(scoreBlue));
        txtScoreYellow.setText(String.valueOf(scoreYellow));

        FragmentTransaction ft = dt.beginTransaction();

        ft.add(R.id.goalkeeperBlue, PlayerFragment.newInstance(blue, "CORONA"));
        ft.add(R.id.playerLeftBlue, PlayerFragment.newInstance(blue, "MAZA"));
        ft.add(R.id.playerRightBlue, PlayerFragment.newInstance(blue, "CHACO GIMENEZ"));

        ft.add(R.id.goalkeeperYellow, PlayerFragment.newInstance(yellow, "MOI MUÑOZ"));
        ft.add(R.id.playerLeftYellow, PlayerFragment.newInstance(yellow, "SAMBU"));
        ft.add(R.id.playerRightYellow, PlayerFragment.newInstance(yellow, "LAYUN"));

        ft.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        startGame();
    }

    public void startGame(){
        if ( dt != null ){

            if ( positionStr != null ){
                PlayerFragment playerFragment = (PlayerFragment) dt.getFragments().get(PlayerFragment.getRandomPosition(0, position));
                playerFragment.showBall(true);
            }else{
                int index = (dt.getFragments().size() > 1)? dt.getFragments().size() - 1: 0;

                PlayerFragment playerFragment = (PlayerFragment) dt.getFragments().get(PlayerFragment.getRandomPosition(0, index));
                playerFragment.showBall(true);
            }
        }
    }

    public void deleteBall(){
        for( Fragment fragment: dt.getFragments() ){
            PlayerFragment playerFragment = (PlayerFragment) fragment;
            playerFragment.showBall(false);
        }
    }

    @Override
    public void passBall(int position) {

        if ( position == 0 ){
            scoreYellow++;
        }else if( position == 3 ){
            scoreBlue++;
        }

        if ( scoreBlue == 5 || scoreYellow == 5 ){
            scoreBlue = 0;
            scoreYellow = 0;
        }

        this.position = position;

        txtScoreBlue.setText(String.valueOf(scoreBlue));
        txtScoreYellow.setText(String.valueOf(scoreYellow));

        deleteBall();
        PlayerFragment playerFragment = (PlayerFragment) dt.getFragments().get(position);
        playerFragment.showBall(true);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("scoreBlue", scoreBlue);
        outState.putInt("scoreYellow", scoreYellow);
        outState.putString("position", String.valueOf(position));
    }


}
