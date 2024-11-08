/*
 * package in.co.rays.project_3.controller;
 * 
 * import java.io.IOException; import java.util.HashMap; import java.util.Map;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import in.co.rays.project_3.dto.BaseDTO; import
 * in.co.rays.project_3.dto.AbcDTO; import
 * in.co.rays.project_3.exception.ApplicationException; import
 * in.co.rays.project_3.exception.DuplicateRecordException; import
 * in.co.rays.project_3.model.AbcModelInt; import
 * in.co.rays.project_3.model.ModelFactory;
 * 
 * import in.co.rays.project_3.util.DataUtility; import
 * in.co.rays.project_3.util.DataValidator; import
 * in.co.rays.project_3.util.PropertyReader; import
 * in.co.rays.project_3.util.ServletUtility;
 * 
 * @WebServlet(name = "AbcCtl", urlPatterns = { "/ctl/AbcCtl" })
 * 
 * public class AbcCtl extends BaseCtl {
 * 
 * @Override protected void preload(HttpServletRequest request) { Map map = new
 * HashMap();
 * 
 * map.put("1", "abc@gmail.com"); map.put("2", "pqr@gmail.com"); map.put("3",
 * "inj@gmail.com");
 * 
 * request.setAttribute("login", map);
 * 
 * }
 * 
 * protected boolean validate(HttpServletRequest request) { boolean pass = true;
 * 
 * if (DataValidator.isNull(request.getParameter("name"))) {
 * request.setAttribute("name", PropertyReader.getValue("error.require",
 * "name")); pass = false; }
 * 
 * else if (!DataValidator.isName(request.getParameter("name"))) {
 * request.setAttribute("name", "name must contains alphabets only");
 * System.out.println(pass); pass = false;
 * 
 * } if (DataValidator.isNull(request.getParameter("login"))) {
 * request.setAttribute("login", PropertyReader.getValue("error.require",
 * "login")); pass = false; }
 * 
 * if (DataValidator.isNull(request.getParameter("password"))) {
 * request.setAttribute("password", PropertyReader.getValue("error.require",
 * "password")); pass = false; } if
 * (DataValidator.isNull(request.getParameter("number"))) {
 * request.setAttribute("number", PropertyReader.getValue("error.require",
 * "number")); pass = false; } return pass;
 * 
 * }
 * 
 * protected BaseDTO populateDTO(HttpServletRequest request) { AbcDTO dto = new
 * AbcDTO();
 * 
 * System.out.println(request.getParameter("dob"));
 * 
 * dto.setId(DataUtility.getLong(request.getParameter("id")));
 * dto.setName(DataUtility.getString(request.getParameter("name")));
 * dto.setLogin(DataUtility.getString(request.getParameter("login")));
 * dto.setPassword(DataUtility.getString(request.getParameter("password")));
 * 
 * dto.setNumber(DataUtility.getInt(request.getParameter("number")));
 * 
 * populateBean(dto, request);
 * 
 * return dto;
 * 
 * }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws IOException, ServletException { String op =
 * DataUtility.getString(request.getParameter("operation")); AbcModelInt model =
 * ModelFactory.getInstance().getAbcModel() long id =
 * DataUtility.getLong(request.getParameter("id")); if (id > 0 || op != null) {
 * AbcDTO dto; try { dto = model.findByPK(id); ServletUtility.setDto(dto,
 * request); } catch (Exception e) { e.printStackTrace();
 * ServletUtility.handleException(e, request, response); return; } }
 * ServletUtility.forward(getView(), request, response); }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws IOException, ServletException { String op =
 * DataUtility.getString(request.getParameter("operation")); AbcModelInt model =
 * ModelFactory.getInstance().getAbcModel(); long id =
 * DataUtility.getLong(request.getParameter("id")); if
 * (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) { AbcDTO dto
 * = (AbcDTO) populateDTO(request); try { if (id > 0) { model.update(dto);
 * 
 * ServletUtility.setSuccessMessage("Data is successfully Update", request); }
 * else {
 * 
 * try { model.add(dto); ServletUtility.setDto(dto, request);
 * ServletUtility.setSuccessMessage("Data is successfully saved", request); }
 * catch (ApplicationException e) { ServletUtility.handleException(e, request,
 * response); return; } catch (DuplicateRecordException e) {
 * ServletUtility.setDto(dto, request);
 * ServletUtility.setErrorMessage("Login id already exists", request); }
 * 
 * } ServletUtility.setDto(dto, request);
 * 
 * } catch (ApplicationException e) { ServletUtility.handleException(e, request,
 * response); return; } catch (DuplicateRecordException e) {
 * ServletUtility.setDto(dto, request);
 * ServletUtility.setErrorMessage("Login id already exists", request); } } else
 * if (OP_DELETE.equalsIgnoreCase(op)) {
 * 
 * AbcDTO dto = (AbcDTO) populateDTO(request); try { model.delete(dto);
 * ServletUtility.redirect(ORSView.ABC_LIST_CTL, request, response); return; }
 * catch (ApplicationException e) { ServletUtility.handleException(e, request,
 * response); return; }
 * 
 * } else if (OP_CANCEL.equalsIgnoreCase(op)) {
 * 
 * ServletUtility.redirect(ORSView.ABC_LIST_CTL, request, response); return; }
 * else if (OP_RESET.equalsIgnoreCase(op)) {
 * 
 * ServletUtility.redirect(ORSView.ABC_CTL, request, response); return; }
 * ServletUtility.forward(getView(), request, response);
 * 
 * }
 * 
 * @Override protected String getView() { // TODO Auto-generated method stub
 * return ORSView.ABC_VIEW; }
 * 
 * }
 */