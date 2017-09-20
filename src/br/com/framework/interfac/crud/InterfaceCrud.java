package br.com.framework.interfac.crud;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import antlr.collections.List;

@Component
@Transactional
public interface InterfaceCrud<T> extends Serializable {
	
	//Salva os dados
	void save(T obj) throws Exception;
	
	void persist(T obj) throws Exception;
	
	//Salva ou atualiza
	void saveOrUpdate(T obj) throws Exception;
	
	//Realiza o update dos dados
	void update(T obj) throws Exception;
	
	//Realiza o delete de dados
	void delete(T obj) throws Exception;
	
	//Salva ou atualiza e retorna o objeto em estado persistente
	T merge(T obj) throws Exception;
	
	//Carrega a lista de dados de determinada classe
	List findList(Class<T> objs) throws Exception;
	
	Object findById(Class<T> entidade, Long id) throws Exception; 
	
	T findByPorId(Class<T> entidade, Long id) throws Exception; 
	
	List findListByQueryDinamica(String s) throws Exception;
		
	//Executar update com HQL
	void executeUpdateQueryDinamica(String s) throws Exception;
	
	//Executar update com SQL
	void executeUpdateSQLDinamica(String s) throws Exception;
	
	//Limpa a sess�o do Hibernate
	void clearSession() throws Exception;
	
	//Retira um objeto da sess�o do Hibernate
	void evict(Object objs) throws Exception;
	
	Session getSession() throws Exception;
	
	List getListSQLDinamica(String SQL) throws Exception;
	
	// JDBC do Spring
	JdbcTemplate getJdbcTemplate();
	
	SimpleJdbcTemplate getSimpleJdbcTemplate();
	
	SimpleJdbcInsert getSimpleJdbcInsert();
	
	SimpleJdbcTemplate getSimpleJdbcTemplateImpl();
	
	Long totalRegistro(String table) throws Exception;
	
	Query obterQuery(String query) throws Exception;
	
	//Carregamento dinamico com JSF e PrimeFaces
	List findListByQueryDinamica(String query, int iniciaNoRegistro, int maximoResultado) throws Exception;
	
	

}
