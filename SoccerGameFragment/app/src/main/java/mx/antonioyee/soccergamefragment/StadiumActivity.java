package mx.antonioyee.soccergamefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StadiumActivity extends AppCompatActivity implements PlayerFragment.PlayerChat {

    private FragmentManager dt;
    private int blue, yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);

        this.blue = getResources().getColor(R.color.blue);
        this.yellow = getResources().getColor(R.color.yellow);

        this.dt = getSupportFragmentManager();

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
            int index = (dt.getFragments().size() > 1)? dt.getFragments().size() - 1: 0;

            PlayerFragment playerFragment = (PlayerFragment) dt.getFragments().get(PlayerFragment.getRandomPosition(0, index));
            playerFragment.showBall(true);
        }
    }

    public void deleteBall(){
        for(Fragment fragment: dt.getFragments() ){
            PlayerFragment playerFragment = (PlayerFragment) fragment;
            playerFragment.showBall(false);
        }
    }

    @Override
    public void passBall(int position) {
        deleteBall();
        PlayerFragment playerFragment = (PlayerFragment) dt.getFragments().get(position);
        playerFragment.showBall(true);
    }
}
