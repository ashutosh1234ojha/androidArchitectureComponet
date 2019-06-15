package com.androidarchitecturecomponents.mvvm.di;

import com.androidarchitecturecomponents.mvvm.viewmodel.ProjectListViewModel;
import com.androidarchitecturecomponents.mvvm.viewmodel.ProjectViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface ViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();
    ProjectViewModel projectViewModel();
}
