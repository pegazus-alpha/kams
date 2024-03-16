package com.example.flag;
import android.graphics.Rect;
import android.net.LinkAddress;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Onglet1 extends Fragment {
    private ScrollView scrol;
    int scrollPosition  ;
    LinearLayout logo;
    TextView text2,pro,zen,huit;
    LinearLayout text3;
    LinearLayout aven1;
    LinearLayout aven2;
    LinearLayout aven3;
    LinearLayout aven4;
    LinearLayout peope;
    LinearLayout wa,wb,wc,wd,xa,xb,xc,route;
    LinearLayout etu;
    Button button1,button2,button3;
    Boolean isElementVisible;
    int [] nbv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_un, container, false);
         logo=view.findViewById(R.id.text1);
         text2=view.findViewById(R.id.text2);
         text3=view.findViewById(R.id.text3);
         aven1=view.findViewById(R.id.aven1);
         aven2=view.findViewById(R.id.aven2);
         aven3=view.findViewById(R.id.aven3);
         aven4=view.findViewById(R.id.aven4);
         route=view.findViewById(R.id.route);
         wa=view.findViewById(R.id.wa);
         wb=view.findViewById(R.id.wb);
         wc=view.findViewById(R.id.wc);
         wd=view.findViewById(R.id.wd);
         xa=view.findViewById(R.id.xa);
         xb=view.findViewById(R.id.xb);
         xc=view.findViewById(R.id.xc);
         pro=view.findViewById(R.id.pro);
         peope=view.findViewById(R.id.peope);
         huit=view.findViewById(R.id.huit);
         zen=view.findViewById(R.id.zen);
         button1=view.findViewById(R.id.button1);
         etu=view.findViewById(R.id.aun);
        scrol=view.findViewById(R.id.scrol);
        isElementVisible=true;
        nbv=new int[20];
        for(int i=0;i<20;i++)
            nbv[i]=0;
        //scoll
        if(saveInstanceState!=null){
            scrollPosition=saveInstanceState.getInt("scrollPosition",0);
            scrol.post(()->scrol.scrollTo(0,scrollPosition));
        }
        //....

        scrol.getViewTreeObserver().addOnScrollChangedListener(()->{
            /*if(logo.isShown())
                gvd(logo);
            if (text2.isShown())
                tg(text2);
            if (button1.isShown())
                bvh(button1);
            if(etu.isShown())
                td(etu);
            if(text3.isShown())
                hvb(text3);
            if (aven1.isShown()){
                hvb(aven1);
                hvb(aven4);
                bvh(aven2);
                bvh(aven3);
            }*/
            Rect scrollBounds=new Rect();
            scrol.getHitRect(scrollBounds);
            Rect viewBounds=new Rect();
            if(logo.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[0]==0){
                //if(isElementVisible==true && nbv<1){

                        gvd(logo);
                        tg(text2);
                        //bvh(button1);
                        nbv[0]++;
                        /*System.out.println(nbv);
                        System.out.println(isElementVisible);*/
                }
                else if(!(logo.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){

                    nbv[0]=0;
                    /*System.out.println(nbv);
                    System.out.println(isElementVisible);*/
                }
           if(button1.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[1]==0){
                bvh(button1);
                td(etu);
                hvb(text3);
                nbv[1]++;
            }
            else if(!(button1.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){

              // nbv[1]=0;
            }
            if(pro.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[2]==0){
                hvb(pro);
                bvh(xa);
                bvh(xb);
                bvh(xc);
                nbv[2]++;
            }
            else if(!(pro.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){
                //nbv[2]=0;
            }
            if(wd.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[3]==0){
                center(route);
                nbv[3]++;
            }
            else if(!(wd.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){

                //nbv[3]=0;
            }
            if(aven1.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[4]==0){
                hvb(aven1);
                hvb(aven4);
                bvh(aven2);
                bvh(aven3);
                bvh(peope);
                nbv[4]++;
            }
            else if(!(aven1.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){

                //nbv[4]=0;
            }
            if(peope.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[5]==0){
                hvb(huit);
                gvd(wa);
                gvd(wb);
                dvg(wc);
                dvg(wd);
                nbv[5]++;
            }
            else if(!(peope.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){

               // nbv[5]=0;
            }
            if(zen.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds) && nbv[6]==0){
                gvd(zen);
                nbv[6]++;
            }
            else if(!(zen.getGlobalVisibleRect(viewBounds) && viewBounds.intersect(scrollBounds))){

                // nbv[5]=0;
            }
        });
        gvd(logo);
        tg(text2);
        bvh(button1);
        td(etu);
        hvb(text3);


        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scollPosition",scrol.getScrollY());
    }

    private void gvd(View logo){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.bas_animation);
        logo.startAnimation(logoAnimation);
    }
    private void dvg(View logo){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.bas_animation2);
        logo.startAnimation(logoAnimation);
    }
    private void center(View logo){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.center);
        logo.startAnimation(logoAnimation);
    }
    private void tg(View l){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.haut_animation);
        l.startAnimation(logoAnimation);
    }
    private void bvh(View l){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.bvh);
        l.startAnimation(logoAnimation);
    }
    private void td(View l){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.haut_animation2);
        l.startAnimation(logoAnimation);
    }
    private void hvb(View l){
        AnimationSet logoAnimation=(AnimationSet) AnimationUtils.loadAnimation(getContext(),R.anim.hvb);
        l.startAnimation(logoAnimation);
    }
}
