package com.example.zy_manage.Fragment;
import androidx.fragment.app.Fragment;
import com.example.zy_manage.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkFragment extends BaseFragment {


    public WorkFragment() {

    }


    // TODO: Rename and change types and number of parameters
    public static WorkFragment newInstance() {
        WorkFragment fragment = new WorkFragment();
        return fragment;
    }


    @Override
    protected int initLayout() {
        return R.layout.fragment_work;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}