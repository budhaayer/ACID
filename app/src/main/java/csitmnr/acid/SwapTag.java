package csitmnr.acid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewParent;

/**
 * Created by Manoj Budha Ayer on 10/29/2016.
 */
public class SwapTag extends AppCompatActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swap_tag);
        viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
    }
    public class MyAdapter extends FragmentPagerAdapter{


        public MyAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment frag = null;
            if (position==0){
                frag = new FSwapA();
            }
            else if (position==1){
                frag = new FSwapB();
            }
            else if (position==2){
                frag = new FSwapC();
            }
        return frag;
        }


        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            String title = null;
                    if(position==0){
                        title = "Tab 1";
                    }else if(position == 1){
                        title = "Tab 2";
                    }else if(position==2){
                        title = "Tab 3";
                    }
            return title;
        }
    }
}
