package service.AdService.dto;

import java.util.List;

public class AdPicDTO {
    private String file;
    private List<String> fileSource;

    public AdPicDTO() {
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<String> getFileSource() {
        return fileSource;
    }

    public void setFileSource(List<String> fileSource) {
        this.fileSource = fileSource;
    }
}
