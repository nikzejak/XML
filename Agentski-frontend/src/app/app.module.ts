import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {LoginComponent} from './components/login/login.component';
import {HomePageComponent} from './components/home-page/home-page.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {MatFormFieldModule, MatNativeDateModule, MatPaginatorModule, MatTableModule} from '@angular/material';
import {LayoutModule} from '@angular/cdk/layout';
import {DemoMaterialModule} from './material-module';
import { AgentHomeComponent } from './components/agent-home/agent-home.component';
import {AddAdComponent} from './components/add-ad/add-ad.component';
import {AdViewDialogComponent} from './components/ad-view-dialog/ad-view-dialog.component';
import {AddPicturesDialogComponent} from './components/add-pictures-dialog/add-pictures-dialog.component';
import { AgentAdsComponent } from './components/agent-ads/agent-ads.component';
import {RentDialogComponent} from './components/rent-dialog/rent-dialog.component';
import { InboxComponent } from './components/inbox/inbox.component';
import { AgentRentedCarsComponent } from './components/agent-rented-cars/agent-rented-cars.component';
import { ConversationDialogComponent } from './components/conversation-dialog/conversation-dialog.component';
import { SendMessageDialogComponent } from './components/send-message-dialog/send-message-dialog.component';
import { ReplyMessageDialogComponent } from './components/reply-message-dialog/reply-message-dialog.component';
import { ViewRateAndCommentsComponent } from './components/view-rate-and-comments/view-rate-and-comments.component';
import { RateDialogComponentComponent } from './components/rate-dialog-component/rate-dialog-component.component';
import { AgentReservedCarsComponent } from './components/agent-reserved-cars/agent-reserved-cars.component';
import { AddPriceListComponent } from './components/add-price-list/add-price-list.component';
import { PricelistViewDialogComponent } from './components/pricelist-view-dialog/pricelist-view-dialog.component';
import { DistanceDialogComponent } from './components/distance-dialog/distance-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomePageComponent,
    AgentHomeComponent,
    AddAdComponent,
    AdViewDialogComponent,
    AddPicturesDialogComponent,
    AgentAdsComponent,
    RentDialogComponent,
    InboxComponent,
    AgentRentedCarsComponent,
    ConversationDialogComponent,
    SendMessageDialogComponent,
    ReplyMessageDialogComponent,
    ViewRateAndCommentsComponent,
    AgentRentedCarsComponent,
    RateDialogComponentComponent,
    AgentReservedCarsComponent,
    AddPriceListComponent,
    PricelistViewDialogComponent,
    DistanceDialogComponent,
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
    FormsModule,
    MatNativeDateModule,
    DemoMaterialModule,

  ],
  entryComponents: [
    AddAdComponent,
    AdViewDialogComponent,
    AddPicturesDialogComponent,
    RentDialogComponent,
    ConversationDialogComponent,
    RateDialogComponentComponent,
    SendMessageDialogComponent,
    PricelistViewDialogComponent,
    DistanceDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
