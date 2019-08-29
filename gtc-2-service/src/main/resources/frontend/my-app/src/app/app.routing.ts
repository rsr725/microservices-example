import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { TestRequestComponent } from './test-request/test-request.component';
import { AuthGuard } from './_guards';
import { TestResultsComponent } from './test-results/test-results.component';

const appRoutes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent },
    {path:'test-request', component:TestRequestComponent},
    {path:'test-results', component:TestResultsComponent}


    // otherwise redirect to home
    //{ path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);