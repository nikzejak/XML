import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {HomePageComponent} from './components/home-page/home-page.component';
import {LoginComponent} from './components/login/login.component';
import {AdministratorHomePageComponent} from './components/administrator-home-page/administrator-home-page.component';
import {EndUserHomePageComponent} from './components/end-user-home-page/end-user-home-page.component';
import {AddAdComponent} from './components/add-ad/add-ad.component';
import {CarSearchComponent} from './components/car-search/car-search.component';
import {AddFuelTypeComponent} from './components/add-fuel-type/add-fuel-type.component';
import {AddTransmissionTypeComponent} from './components/add-transmission-type/add-transmission-type.component';
import {AddCarTypeComponent} from './components/add-car-type/add-car-type.component';
import {AddCarBrandComponent} from './components/add-car-brand/add-car-brand.component';
import {AddCarModelComponent} from './components/add-car-model/add-car-model.component';
import {EndUsersOperationsComponent} from './components/end-users-operations/end-users-operations.component';
import {RentConditionsComponent} from './components/rent-conditions/rent-conditions.component';
import {CodeBookComponent} from './components/code-book/code-book.component';
import {EndUserAdsComponent} from './components/end-user-ads/end-user-ads.component';
import {ContactComponent} from './components/contact/contact.component';
import {AboutUsComponent} from './components/about-us/about-us.component';
import {RentingRequestsComponent} from './components/renting-requests/renting-requests.component';
import {EndUserRentedCarsComponent} from './components/end-user-rented-cars/end-user-rented-cars.component';
import {InboxComponent} from './components/inbox/inbox.component';
import {CommentOperationComponent} from './components/comment-operation/comment-operation.component';
import {RegistrationComponent} from './components/registration/registration.component';
import {AddAgentComponent} from './components/add-agent/add-agent.component';
import {AddFirmComponent} from './components/add-firm/add-firm.component';
import {AdministratorPerimissionsComponent} from './components/administrator-perimissions/administrator-perimissions.component';
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
    path: 'register',
    component: RegistrationComponent,
  },
  {
    path: 'administrator/home',
    component: AdministratorHomePageComponent,
  },
  {

    path: 'endUser/home',
    component: EndUserHomePageComponent,
  },
  {
    path: 'endUser/addAd',
    component: AddAdComponent,
  },

  { path: 'search',
    component: CarSearchComponent,
  },
  {
    path: 'addFuelType',
    component: AddFuelTypeComponent,
  },
  {
    path: 'addTransmissionType',
    component: AddTransmissionTypeComponent,
  },
  {
    path: 'addCarType',
    component: AddCarTypeComponent,
  },
  {
    path: 'addCarBrand',
    component: AddCarBrandComponent,
  },
  {
    path: 'addCarModel',
    component: AddCarModelComponent,
  },
  {
    path: 'administrator/end-users-operations',
    component: EndUsersOperationsComponent,
  },

  {
    path: 'search',
    component: CarSearchComponent,
  },
  {
    path: 'rentConditions',
    component: RentConditionsComponent,
  },
  {
    path: 'codeBook',
    component: CodeBookComponent,
  },
  {
    path: 'endUser/myAds',
    component: EndUserAdsComponent,
  },
  {
    path: 'endUser/rentingRequests',
    component: RentingRequestsComponent,
  },
  {
    path: 'endUser/rentedCars',
    component: EndUserRentedCarsComponent,
  },
  {
    path: 'Contact',
    component: ContactComponent,
  },
  {
    path: 'About',
    component: AboutUsComponent,
  },
  {
    path: 'endUser/About',
    component: AboutUsComponent,
  },
  {
    path: 'endUser/Contact',
    component: ContactComponent,
  },
  {
    path: 'endUser/rentConditions',
    component: RentConditionsComponent,
  },
  {
    path: 'endUser/addPriceList',
    component: AddPriceListComponent,
  },
  {
    path: 'inbox',
    component: InboxComponent
  },
  {
    path: 'administrator/commentForOperation',
    component: CommentOperationComponent,
  },
  {
    path: 'administrator/addAgent',
    component: AddAgentComponent,
  },
  {
    path: 'administrator/addFirm',
    component: AddFirmComponent,
  },
  {
    path: 'administrator/permissions',
    component: AdministratorPerimissionsComponent,
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
