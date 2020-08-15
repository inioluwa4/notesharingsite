export class UrlService {
  private static readonly MONOLITH_URL = 'http://localhost:8080/notesharing/';
  constructor() { }
  public getUrl(): string {
    return UrlService.MONOLITH_URL;
  }
}
