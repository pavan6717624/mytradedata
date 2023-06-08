import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest, HttpResponse } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ChartService {

  constructor(private http: HttpClient) { }


  getData(formData: FormData) {
    return this.http.post('http://localhost:8089/getData',formData)
  }


  getCEPE(formData: FormData) {
    return this.http.post('http://localhost:8089/getCEPE',formData)
  }

 

  getLastPrice(formData: FormData) {
    return this.http.post('http://localhost:8089/getLastPrice',formData)
  }
}
