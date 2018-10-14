function initMap() {
  var liivi2 = {lat: 58.3782485, lng: 26.7146733};

  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 17, center: liivi2});

  var marker = new google.maps.Marker({position: liivi2, map: map});
}