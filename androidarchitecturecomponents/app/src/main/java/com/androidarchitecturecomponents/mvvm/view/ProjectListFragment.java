package com.androidarchitecturecomponents.mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.androidarchitecturecomponents.mvvm.Project.Project;
import com.androidarchitecturecomponents.mvvm.viewmodel.ProjectListViewModel;
import com.google.android.gms.common.api.internal.LifecycleFragment;

import java.util.List;

public class ProjectListFragment  extends Fragment implements LifecycleFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ProjectListViewModel viewModel =
                ViewModelProviders.of(this).get(ProjectListViewModel.class);

        observeViewModel(viewModel);    }


    private void observeViewModel(ProjectListViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getProjectListObservable().observe(this, new Observer<List<Project>>() {
            @Override
            public void onChanged(@Nullable List<Project> projects) {
                if (projects != null) {
                    //…
                    projectAdapter.setProjectList(projects);
                }
            }
        });
    }
}
