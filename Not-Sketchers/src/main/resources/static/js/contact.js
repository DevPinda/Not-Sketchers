function emailUs() {
  window.location.href = "mailto:enquiry@solesource.co.uk";
}

function call() {
  if (/(android|iphone|ipad|ipod|windows phone)/i.test(navigator.userAgent)) {
    location.href = "+44 121 204 3000";
  } else {
    window.alert(
      "Unfortunately, your device is not equipped to make phone calls. Please send us an email at enquiry@solesource.co.uk"
    );
  }
}
