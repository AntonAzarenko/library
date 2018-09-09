package library.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import library.dao.BookDao;
import library.entity.Book;

public class BookServiceImpl implements BookService {

    @Autowired
    private ServletContext context;

    private BookDao dao;

    public void setBookDao(final BookDao dao) {
        this.dao = dao;
    }

    @Override
    public Book getById(final Long id) {
        return dao.read(id);
    }

    @Override
    public List<Book> getBooks() {
        return dao.readAll();
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return dao.find(title);
    }

    @Override
    public void save(final Book book) {
        if (book.getId() == null) {
            dao.create(book);
        } else {
            dao.update(book);
        }
    }

    @Override
    public List<Book> getBooksByAuthor(final Long id) {
        return dao.findByAuthorId(id);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public List<Book> getBooksByPublisher(final String name) {
        return dao.findBooksByPublisher(name);
    }

    @Override
    public String upload(MultipartFile file, String path) {
        String name = null;
        String filePath = null;
        String fileUrl = null;
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        try {
            byte[] bytes = file.getBytes();
            name = file.getOriginalFilename();

            filePath = context.getRealPath("") + "uploads" + File.separator +
                    year + File.separator + month + File.separator + path;
            Path resourceDirectory = Paths.get(filePath);

            File dir = new File(resourceDirectory + File.separator);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File loadFile = new File(dir.getAbsolutePath() + File.separator + name);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(loadFile));
            stream.write(bytes);
            stream.flush();
            stream.close();
            fileUrl = "uploads/" + year + "/" + month + "/" + path + "/" + name;
        } catch (IOException e) {

        }
        return fileUrl;
    }
}
