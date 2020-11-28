import { Component, OnInit } from '@angular/core';
// import { UploadService } from 'src/app/services/upload.service';


@Component({
  selector: 'app-share-notes',
  templateUrl: './share-notes.component.html',
  styleUrls: ['./share-notes.component.css']
})
export class ShareNotesComponent implements OnInit {
  toFile;

  // constructor(private uploadService: UploadService) { }

  ngOnInit() {
  }

  submit() {
    const file = this.toFile.item(0);
    // this.uploadService.fileUpload(file);
  }

  onChange(event) {
    this.toFile = event.target.files;

  }

}




