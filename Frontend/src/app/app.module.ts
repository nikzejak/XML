import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {

  MatCardModule, MatFormFieldModule,
  MatNativeDateModule,
  MatIconModule,
  MatListModule,
  MatPaginatorModule,
  MatSidenavModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';



import {RouterModule} from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import { AdministratorHomePageComponent } from './components/administrator-home-page/administrator-home-page.component';
import { EndUserHomePageComponent } from './components/end-user-home-page/end-user-home-page.component';
import { AddAdComponent } from './components/add-ad/add-ad.component';
import {LayoutModule} from '@angular/cdk/layout';
import { AddFuelTypeComponent } from './components/add-fuel-type/add-fuel-type.component';
import { AddTransmissionTypeComponent } from './components/add-transmission-type/add-transmission-type.component';
import { AddCarTypeComponent } from './components/add-car-type/add-car-type.component';
import { AddCarBrandComponent } from './components/add-car-brand/add-car-brand.component';
import { AddCarModelComponent } from './components/add-car-model/add-car-model.component';
import { EndUsersOperationsComponent } from './components/end-users-operations/end-users-operations.component';
import { CarSearchComponent } from './components/car-search/car-search.component';
import {DemoMaterialModule} from './material-module';
import { SearchResultDialogComponent } from './components/search-result-dialog/search-result-dialog.component';
import { AdViewDialogComponent } from './components/ad-view-dialog/ad-view-dialog.component';
import { RentConditionsComponent } from './components/rent-conditions/rent-conditions.component';
import { CodeBookComponent } from './components/code-book/code-book.component';
import { AddPicturesDialogComponent } from './components/add-pictures-dialog/add-pictures-dialog.component';
import { EndUserAdsComponent } from './components/end-user-ads/end-user-ads.component';
import { CartDialogComponent } from './components/cart-dialog/cart-dialog.component';
import { ContactComponent } from './components/contact/contact.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { RentDialogComponent } from './components/rent-dialog/rent-dialog.component';
import { RentingRequestsComponent } from './components/renting-requests/renting-requests.component';
import { SendMessageDialogComponent } from './components/send-message-dialog/send-message-dialog.component';
import { EndUserRentedCarsComponent } from './components/end-user-rented-cars/end-user-rented-cars.component';
import { RateDialogComponent } from './components/rate-dialog/rate-dialog.component';
import { InboxComponent } from './components/inbox/inbox.component';
import { ConversationDialogComponent } from './components/conversation-dialog/conversation-dialog.component';
import { ReplyMessageDialogComponent } from './components/reply-message-dialog/reply-message-dialog.component';
import { CommentOperationComponent } from './components/comment-operation/comment-operation.component';
import { AdvancedSearchDialogComponent } from './components/advanced-search-dialog/advanced-search-dialog.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { AddAgentComponent } from './components/add-agent/add-agent.component';
import { AddFirmComponent } from './components/add-firm/add-firm.component';
import { AdministratorPerimissionsComponent } from './components/administrator-perimissions/administrator-perimissions.component';
import {AddPriceListComponent} from './components/add-price-list/add-price-list.component';
import {PricelistViewDialogComponent} from './components/pricelist-view-dialog/pricelist-view-dialog.component';
import { RateBundleComponent } from './components/rate-bundle/rate-bundle.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginComponent,
    AdministratorHomePageComponent,
    EndUserHomePageComponent,
    AddAdComponent,
    CarSearchComponent,
    AddFuelTypeComponent,
    AddTransmissionTypeComponent,
    AddCarTypeComponent,
    AddCarBrandComponent,
    AddCarModelComponent,
    EndUsersOperationsComponent,
    CarSearchComponent,
    SearchResultDialogComponent,
    AdViewDialogComponent,
    RentConditionsComponent,
    CodeBookComponent,
    AddPicturesDialogComponent,
    EndUserAdsComponent,
    CartDialogComponent,
    ContactComponent,
    AboutUsComponent,
    RentDialogComponent,
    RentingRequestsComponent,
    SendMessageDialogComponent,
    EndUserRentedCarsComponent,
    RateDialogComponent,
    InboxComponent,
    ConversationDialogComponent,
    ReplyMessageDialogComponent,
    CommentOperationComponent,
    AdvancedSearchDialogComponent,
    RegistrationComponent,
    AddAgentComponent,
    AddFirmComponent,
    AdministratorPerimissionsComponent,
    AddPriceListComponent,
    PricelistViewDialogComponent,
    RateBundleComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    RouterModule,
    MatCardModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    MatFormFieldModule,
    MatTableModule,
    MatPaginatorModule,
    LayoutModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    DemoMaterialModule,
    MatTableModule,
    MatPaginatorModule,
    DemoMaterialModule,

  ],

  entryComponents: [AddAdComponent, SearchResultDialogComponent, AdViewDialogComponent, AddPicturesDialogComponent,
    CartDialogComponent, RentDialogComponent, SendMessageDialogComponent, RateDialogComponent, ConversationDialogComponent,
	  ReplyMessageDialogComponent, AdvancedSearchDialogComponent, PricelistViewDialogComponent, RateBundleComponent],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
