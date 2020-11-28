import { Injectable } from '@angular/core';
import * as AWS from 'aws-sdk/global';
import * as S3 from 'aws-sdk/clients/s3';




@Injectable({
  providedIn: 'root'
})
export class UploadService {

  constructor() { }

  fileUpload(file) {
    const contentType = file.type;
    const bucket = new S3(
          {
              accessKeyId: 'AKIA53FE5KKELSN5C2ZX',
              secretAccessKey: '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',
              region: 'us-east-2',
            
          }
      );
      const params = {
          Bucket: 'notesharing-bucket',
          Key:  file.name,
          Body: file,
          ACL: 'public-read',
          ContentType: contentType
      };
      bucket.upload(params, function (err, data) {
          if (err) {
              console.log('EROOR: ',JSON.stringify( err));
              return false;
          }
          console.log('File Uploaded.', data);
          return true;
      });
    }
}
