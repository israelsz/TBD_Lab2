<template>
  <div>
    <NavBar />
    <div class="home">

      <h1>Ubicacion de las tareas:</h1>

      <div class="dropdown mt-4 mb-4">
        <span class="mr-3">Region:</span>
        <select v-model="regionSeleccionada" @change="onChangeRegion">
          <option value="">Selecione una region</option>
          <option v-for="(region, gid) in regiones" :value="region" :key="gid">
            {{ region.nom_reg }}
          </option>
        </select>
      </div>

      <div id="map"></div>
    </div>
  </div>
</template>

<script>
//Importaciones
import "leaflet/dist/leaflet"; //librería leaflet
import "leaflet/dist/leaflet.css"; //css leaflet
var icon = require("leaflet/dist/images/marker-icon.png"); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
  options: { iconSize: [25, 41], iconAnchor: [12, 41], popupAnchor: [-3, -41] },
});
var myIcon = new LeafIcon({ iconUrl: icon });
//librería axios

export default {
  name: "Home",
  data: function () {
    return {
      tareas:[],
      poligono: [],
      regiones: [],
      regionSeleccionada: "",
      latitude: null, //Datos de nuevo punto
      longitude: null,
      name: "",
      points: [], //colección de puntos cargados de la BD
      message: "",
      mymap: null, //objeto de mapa(DIV)
    };
  },
  computed: {
    point() {
      // función computada para representar el punto seleccionado
      if (this.latitude && this.longitude) {
        let lat = this.latitude.toFixed(3);
        let lon = this.longitude.toFixed(3);
        return `(${lat}, ${lon})`;
      } else {
        return "";
      }
    },
  },
  methods: {
    clearMarkers: function () {
      //eliminar marcadores

      this.points.forEach((p) => {
        this.map.removeLayer(p);
      });

      this.poligono.forEach((p) => {
        this.map.removeLayer(p);
      });

      this.points = [];
      this.poligono = [];
    },
     async conseguirRegiones() {
      const respuesta = await this.$axios.$get("/regiones");
      this.regiones = respuesta;
    },
    async onChangeRegion() {
      this.clearMarkers(this.map);

      const respuesta2 = await this.$axios.$get(`/polyregion/${this.regionSeleccionada.gid}`);

      if(respuesta2[0].array_to_string == null){
        return;
      }

      let arregloPoly = respuesta2[0].array_to_string.split(",");
      for (let i = 0; i < arregloPoly.length; i++) {
        arregloPoly[i] = arregloPoly[i].split(" ");
        let aux = arregloPoly[i][0];
        arregloPoly[i][0] = arregloPoly[i][1];
        arregloPoly[i][1] = aux;
      }

      let poligono = L.polygon(arregloPoly).addTo(this.map);

      this.poligono.push(poligono);
      
      const respuesta3 = await this.$axios.$get(`/tareaByRegion/${this.regionSeleccionada.gid}`);
      this.tareas = respuesta3;

      let dataPoints = respuesta3;
        //Se itera por los puntos
        dataPoints.forEach((point) => {
          //Se crea un marcador por cada punto
          let p = [point.longitude, point.latitude];
          let marker = L.marker(p, "leaflet/dist/images/marker-icon.png") //se define el ícono del marcador
            .bindPopup(point.nombre).openPopup(); //Se agrega un popup con el nombre

          //Se agrega a la lista
          this.points.push(marker);

           //Los puntos de la lista se agregan al mapa
          this.points.forEach((p) => {
            p.addTo(this.map);
          });
    
        });
      
    }     
  },
  mounted: function () {
  


     let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.map = L.map('map').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    	attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
    	maxZoom: 10
    }).addTo(this.map);
   
    //Se cargan las regiones
    this.conseguirRegiones();

  },
};
</script>

<style>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
}
/* Estilos necesarios para definir el objeto de mapa */
#map {
  height: 600px;
  width: 800px;
}
</style>
