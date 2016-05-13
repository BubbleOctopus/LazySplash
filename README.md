# LazySplash
Splash页面

  技术及效果描述：
  
  1.使用ViewPager + fragment
  
  2.在滑动的过程中修改器ViewPager背景色，颜色变化是个渐变的过程，背景色的计算有每个ViewPager的item中的Fragemnt中指定的颜色为开始和结束颜色
  
  3.同时滑动过程中允许你为每个item中的view加入位移动画。

#How to use?
  控制器LazyViewPagrFragment,继承这个类实现其三个方法一个是获取Fragment数量，一个是获取当前ViewPager的item，最后一个是获取指定的item的颜色的方法。
  例如Demo app:
    /**
 * Created by liemng on 16-5-13.
 */
public class ViewPagerFragment extends LazyViewPagerFragment {
    private static final String TAG = ViewPagerFragment.class.getSimpleName();

    private static final int PAGE_NUM = 3;

    private static final int PAGE_ONE = 0;
    private static final int PAGE_TWO = 1;
    private static final int PAGE_THREE = 2;

    @Override
    public int getCount() {
        return PAGE_NUM;
    }

    @Override
    public PageFragment getItem(int position) {
        position %= PAGE_NUM;
        PageFragment mPagerFragment = null;
        switch (position){
            case PAGE_ONE:
                mPagerFragment = new OneFragment();
                break;
            case PAGE_TWO:
                mPagerFragment = new TwoFragment();
                break;
            case PAGE_THREE:
                mPagerFragment = new ThreeFragment();
                break;
            default:
                if(Util.DEBUG)
                    Log.d(TAG,"unknow index fetch fragment, position:" + position);
                break;
        }
        return mPagerFragment;
    }

    @Override
    public int getColor(int position) {
        position %= PAGE_NUM;
        int result =0;
        switch (position){
            case PAGE_ONE:
                result = Color.parseColor("#ff0000");
                break;
            case PAGE_TWO:
                result = Color.parseColor("#00ff00");
                break;
            case PAGE_THREE:
                result = Color.parseColor("#0000ff");
                break;
            default:
                result = Color.TRANSPARENT;
                if(Util.DEBUG)
                    Log.d(TAG,"unknow index fetch color, position:" + position);
                break;
        }

        return result;
    }
}
  
  为控制器填充item，这里的item实现方式需要继承类PageFragment实现其内部方法fetchResourceId()和方法getAnimList();
  例如Demo app：
    class OneFragment extends PageFragment 
    这里说下这两个方法：
      fetchResourceId()这里获取的是你的布局文件的Id，也也就是R.layout.XXX.
      getAnimaList()这里就是设定动画的方法，现在仅仅支持平移动画，所以这里直接写死了，等后续看着在引入泛型支持多种类型的动画。
      这里插入下代码说明下：
      /**
       * Created by liemng on 16-5-13.
       */
      public class OneFragment extends PageFragment {
          private static final String TAG = OneFragment.class.getSimpleName();
      
          @Override
          public int fetchResourceId() {
              return R.layout.one_layout;
          }
      
          @Override
          public TranslationAnim[] getAnimList() {
              return new TranslationAnim[]{
                  new TranslationAnim(R.id.img_one, false, 3)
              };
          }
      
      }
      这里主要想说的是TranslationAnim这里的参数：R.id.img_one这个id就是你的布局文件（R.layout.XXX.）中的一个item，false代表平移动画的方向，如果是true就是正向移动，false是反向移动，这里的方向依据是你viewpager的滑动方向，第三个参数就是一个滑动因子，当然越大滑动的平移就是越小，大小是大于零，最大值暂时未设置，最好不要太大，如果太大其实进行位置移动的过程中就会越小，过大自然也就看不出移动效果了。
      
      使用按照以上两步骤就阔以了，使用相对简单，最后补充一句啊，不要忘记了引入类库，这里是我自己定义，所以大家需要自己下载下来项目，手动引入下拉。。
    
    
#LICENSE
    Copyright 2015-2016 liemng
    
    Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.
    
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
  
