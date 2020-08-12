import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HomePageComponent} from './components/home-page/home-page.component';
import {LoginComponent} from './components/login/login.component';
import {AgentHomeComponent} from './components/agent-home/agent-home.component';
import {AddAdComponent} from './components/add-ad/add-ad.component';
import {AgentAdsComponent} from './components/agent-ads/agent-ads.component';
import {ViewRateAndCommentsComponent} from './components/view-rate-and-comments/view-rate-and-comments.component';
import {AgentRentedCarsComponent} from './components/agent-rented-cars/agent-rented-cars.component';
import {AgentReservedCarsComponent} from './components/agent-reserved-cars/agent-reserved-cars.component';
import {InboxComponent} from './components/inbox/inbox.component';
import {AddPriceListComponent} from './components/add-price-list/add-price-list.component';

const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'agent/home',
    component: AgentHomeComponent,
  },
  {
    path: 'agent/addAd',
    component: AddAdComponent,
  },
  {
    path: 'agent/myAds',
    component: AgentAdsComponent,
  },
  {
    path: 'agent/RateAndComment',
    component: ViewRateAndCommentsComponent,
  },
  {
    path: 'agent/rentedCars',
    component: AgentRentedCarsComponent,
  },
  {
    path: 'agent/myActiveRents',
    component: AgentReservedCarsComponent
  },
  {
    path: 'inbox',
    component: InboxComponent
  },

  {
    path: 'agent/addPriceList',
    component: AddPriceListComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
