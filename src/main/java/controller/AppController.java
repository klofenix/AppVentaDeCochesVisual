package controller;


import model.Moto;
import model.Indrustrial;
import model.Turismo;
import model.Vehiculo.TipoCombustible;
import model.TipoCarroceria;
import model.Medidas;
import model.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;


public class AppController implements Initializable {
    @FXML
    private Pane PPrincipal;
    @FXML
    private RadioButton rbTurismo;
    @FXML
    private RadioButton rbMoto;
    @FXML
    private RadioButton rbIndustrial;
    @FXML
    private ComboBox<TipoCombustible> cbTipoCombustible;
    @FXML
    private ComboBox<TipoCarroceria> cbTipoCarroceria;

    private ObservableList<Vehiculo> vehiculos;
    @FXML
    private ListView<Vehiculo> lvVista;
    @FXML
    private Pane pNumRuedas;
    @FXML
    private Pane tipoVehiculo;
    @FXML
    private TextField tfNumRuedas;
    @FXML
    private TextField tfLargo;
    @FXML
    private TextField tfAncho;
    @FXML
    private TextField tfAlto;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfModelo;
    @FXML
    private TextField tfkm;
    @FXML
    private TextField tfCV;
    @FXML
    private TextField tfPrecio;
    @FXML
    private TextField tfAñoFab;
    @FXML
    private TextField tfTamañoCaja;
    @FXML
    private Button btguardar;
    @FXML
    private Button btBorrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbTipoCarroceria.setDisable(true);
        pNumRuedas.setDisable(true);
        cbTipoCombustible.getItems().addAll(TipoCombustible.values());
        cbTipoCarroceria.getItems().addAll(TipoCarroceria.values());
        vehiculos = FXCollections.observableArrayList();
        lvVista.setItems(vehiculos);
    }
     

    @FXML
    private void SelTurismo(ActionEvent event) {
        cbTipoCarroceria.setDisable(false);
        tfTamañoCaja.setDisable(true);
        pNumRuedas.setDisable(true);
    }

    @FXML
    private void SelMoto(ActionEvent event) {
        pNumRuedas.setDisable(false);
        cbTipoCarroceria.setDisable(true);
        tfTamañoCaja.setDisable(true);
    }

    @FXML
    private void SelIndustrial(ActionEvent event) {
        pNumRuedas.setDisable(true);
        cbTipoCarroceria.setDisable(true);
        tfTamañoCaja.setDisable(false);
    }
    @FXML
    private void guardarVehiculo(ActionEvent event) {
        if (rbTurismo.isSelected()) {
            crearTurismo();
        } else if (rbMoto.isSelected()) {
            crearMoto();
        } else if (rbIndustrial.isSelected()) {
            crearIndustrial();
        }
    }

    @FXML
    private void borrarVehiculo(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        Vehiculo v = this.lvVista.getSelectionModel().getSelectedItem();

        this.vehiculos.remove(v);
        this.lvVista.refresh();
        alerta.setTitle("AVISO");
        alerta.setContentText("El vehículo: " + v.getMarca() + " " + v.getModelo() + " ha sido eliminado.");
        alerta.showAndWait();
    }

    private void crearTurismo() {
        Turismo coche;
        TipoCarroceria tipoCa = cbTipoCarroceria.getValue();
        TipoCombustible tipoCo = cbTipoCombustible.getValue();
        String medidaLargo= tfLargo.getText();
        int largo = Integer.parseInt(medidaLargo);
        String medidaAncho = tfAncho.getText();
        int ancho = Integer.parseInt(medidaAncho);
        String medidaAlto = tfAlto.getText();
        int alto = Integer.parseInt(medidaAlto);
        Medidas medidasCoche = new Medidas(alto, ancho, largo);

        String marca = tfMarca.getText();
        String modelo = tfModelo.getText();
        String anioFab = tfAñoFab.getText();
        int aFabricacion = Integer.parseInt(anioFab);
        String kmStr = tfkm.getText();
        int kms = Integer.parseInt(kmStr);
        String cvStr = tfCV.getText();
        int potenciaCV = Integer.parseInt(cvStr);
        String precioStr = tfPrecio.getText();
        double precio = Double.parseDouble(precioStr);

        coche = new Turismo(marca, modelo, aFabricacion, kms, potenciaCV, precio, tipoCo, medidasCoche, tipoCa);
        lvVista.getItems().add(coche);
        clearFields();

    }

    private void crearMoto() {
        Moto moto;
        moto = new Moto();

        TipoCombustible tipoCom = cbTipoCombustible.getValue();
        moto.setCombustible(tipoCom);

        String medidaL = tfLargo.getText();
        int largo = Integer.parseInt(medidaL);
        String medidaAncho = tfAncho.getText();
        int ancho = Integer.parseInt(medidaAncho);
        String medidaAlto = tfAlto.getText();
        int alto = Integer.parseInt(medidaAlto);
        Medidas medidasMoto = new Medidas(alto, ancho, largo);
        moto.setMedidas(medidasMoto);

        String marcaM = tfMarca.getText();
        moto.setMarca(marcaM);
        String modeloM = tfModelo.getText();
        moto.setModelo(modeloM);
        String anioFab = tfAñoFab.getText();
        int anio = Integer.parseInt(anioFab);
        moto.setAFabricacion(anio);
        String kmStr = tfkm.getText();
        int kmsM = Integer.parseInt(kmStr);
        moto.setKms(kmsM);
        String cvStr = tfCV.getText();
        int cv = Integer.parseInt(cvStr);
        moto.setPotenciaCV(cv);
        String precioStr = tfPrecio.getText();
        double precioM = Double.parseDouble(precioStr);
        moto.setPrecio(precioM);


        String numruedas = tfNumRuedas.getText();
        int numRueda = Integer.parseInt(numruedas);
        moto.setNumRuedas(numRueda);
        lvVista.getItems().add(moto);
        clearFields();

    }

    private void crearIndustrial() {
        Indrustrial indu;
        indu = new Indrustrial();
        TipoCombustible tipoCom = cbTipoCombustible.getValue();
        indu.setCombustible(tipoCom);

        String medidaL = tfLargo.getText();
        int largo = Integer.parseInt(medidaL);
        String medidaAncho = tfAncho.getText();
        int ancho = Integer.parseInt(medidaAncho);
        String medidaAlto = tfAlto.getText();
        int alto = Integer.parseInt(medidaAlto);
        Medidas medidasIndus = new Medidas(alto, ancho, largo);
        indu.setMedidas(medidasIndus);

        String marcaM = tfMarca.getText();
        indu.setMarca(marcaM);
        String modeloM = tfModelo.getText();
        indu.setModelo(modeloM);
        String anioFab = tfAñoFab.getText();
        int anio = Integer.parseInt(anioFab);
        indu.setAFabricacion(anio);
        String kmStr = tfkm.getText();
        int kmsM = Integer.parseInt(kmStr);
        indu.setKms(kmsM);
        String cvStr = tfCV.getText();
        int cv = Integer.parseInt(cvStr);
        indu.setPotenciaCV(cv);
        String precioStr = tfPrecio.getText();
        double precioM = Double.parseDouble(precioStr);
        indu.setPrecio(precioM);
        String tamCaj = tfTamañoCaja.getText();
        float tamC = Float.parseFloat(tamCaj);
        indu.setTamCaja(tamC);

        lvVista.getItems().add(indu);
        clearFields();

    }

    private void clearFields() {
        cbTipoCarroceria.getSelectionModel().clearSelection();
        cbTipoCombustible.getSelectionModel().clearSelection();
        tfMarca.clear();
        tfModelo.clear();
        tfAñoFab.clear();
        tfkm.clear();
        tfCV.clear();
        tfPrecio.clear();
        tfTamañoCaja.clear();
        tfLargo.clear();
        tfAncho.clear();
        tfAlto.clear();
    }
}

