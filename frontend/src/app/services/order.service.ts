import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Order} from "../model/order";


@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private url: string = '/api/orders';

  constructor(private http: HttpClient) {}

  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(this.url);
  }

  saveOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(this.url, order);
  }

  deleteOrder(orderId: string): Observable<void> {
    return this.http.delete<void>(this.url + '/' + orderId);
  }

  getOrdersByBillingAccount(baId): Observable<Order[]> {
    return this.http.get<Order[]>(this.url + '/billing-account/' + baId);
  }

  getOrdersByUser(userId): Observable<Order[]> {
    return this.http.get<Order[]>(this.url + '/user/' + userId);
  }
}
