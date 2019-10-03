package com.yard.stockmanager.tabs;

import com.yard.stockmanager.parts.ManagementTab;
import com.yard.stockmanager.persistence.dao.DepartmentDAO;
import com.yard.stockmanager.persistence.entity.Departamento;
import com.yard.stockmanager.useful.Error;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

public class DepartmentRegisterTab extends ManagementTab<Departamento> {
    private Stage stage;
    private Font font = new Font(14);
    private Departamento selected;

    public DepartmentRegisterTab()
    {
        super("Cadastro de Departamentos");
        initComponents();
    }

    @Override
    public void refresh() {
        DepartmentDAO dao = new DepartmentDAO();

        List<Departamento> list = dao.getAll();

        tableView.setItems(FXCollections.observableArrayList( list ));
        tableView.refresh();
    }

    @Override
    public boolean validate() {
        if(!idField.getText().equals("Novo") && idField.getText().trim().isEmpty()) {
            return false;
        }
        if(tfdDepartamento.getText().trim().isEmpty() || tfdDepartamento.getText().length() <= 3){
            return false;
        }
        return true;
    }

    @Override
    public void save() {
        try
        {
            Departamento f = new Departamento();

            f.setNome(tfdDepartamento.getText());

            f.setDescricao(tarDescricao.getText());

            depDAO.add(f);
        }

        catch (Exception e)
        {
            Error.message(e.getMessage());
        }
    }

    @Override
    public void edit() {
        try{
            Departamento d = (Departamento) getSelected();

            d.setNome(tfdDepartamento.getText());
            d.setDescricao(tarDescricao.getText());

            depDAO.update(d);
        }
        catch (Exception e){
            Error.message(e.getMessage());
        }

        refresh();
    }

    @Override
    public void changeStatus() {
        try
        {
            Departamento f = (Departamento) getSelected();
            depDAO.delete(f.getId());

            refresh();
        }

        catch (Exception e)
        {
            Error.message(e.getMessage());
        }

    }

    @Override
    public void select() {
         selected= (Departamento) getSelected();

        if (selected != null)
        {
            idField.setText(selected.getId().toString());
            tfdDepartamento.setText(selected.getNome());
            tarDescricao.setText(selected.getDescricao());
        }

        else
        {
            clear();
        }
    }

    @Override
    public void clear() {
        setSelected(null);

        idField.setText("Novo");
        tfdDepartamento.setText("");
        tarDescricao.setText("");
    }

    private void initComponents() {
        // Labels
        labDepartamento.setFont(font);
        labDepartamento.setPrefSize(labWidth,labHeight);

        labDescricao.setFont(font);
        labDescricao.setPrefSize(labWidth,labHeight);

        //TextFields
        tfdDepartamento.setEditable(true);
        tfdDepartamento.setFont(font);
        tfdDepartamento.setPrefSize(tfdWidth,tfdHeight);

        idField.setDisable(true);

        //textArea
        tarDescricao.setEditable(true);
        tarDescricao.setFont(font);
        tarDescricao.setPrefSize(tarWidth,tarHeigt);

        //Colunas da tabela
        TableColumn<Departamento, Integer> id = new TableColumn<>("ID");
        TableColumn<Departamento, String> dep = new TableColumn<>("Departamento");
        TableColumn<Departamento, String> desc = new TableColumn<>("Descrição");

        id.setCellValueFactory(new PropertyValueFactory<Departamento, Integer>("id"));
        dep.setCellValueFactory(new PropertyValueFactory<Departamento, String>("Nome"));
        desc.setCellValueFactory(new PropertyValueFactory<Departamento, String>("Descricao"));

        //Tabela
        tableView.setPrefSize(1000, 1000);
        tableView.getColumns().addAll(id, dep, desc);

        innerGrid.addRow(0, labid, idField);
        innerGrid.addRow(1,labDepartamento, tfdDepartamento);
        innerGrid.addRow(2,labDescricao, tarDescricao);

        refresh();
    }

    //Iniciação das variaveis
    private double labWidth = 240;
    private double labHeight = 50;
    private double tfdWidth = 300;
    private double tfdHeight = 20;
    private double tarWidth = 300;
    private double tarHeigt = 50;

    //Criação dos componentes da tela
    private Label labid = new Label("ID:");
    private Label labDepartamento = new Label("Departamento:");
    private Label labDescricao = new Label("Descrição:");

    private TextField idField = new TextField("Novo");
    private TextField tfdDepartamento = new TextField();
    private TextArea tarDescricao = new TextArea();

    //grid
    private GridPane telaPrincipal = new GridPane();
    private GridPane telaEsquerda = new GridPane();
    private GridPane telaDireita = new GridPane();

    //dao
    private DepartmentDAO depDAO = new DepartmentDAO();

}

