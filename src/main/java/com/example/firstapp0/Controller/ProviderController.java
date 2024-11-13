package com.example.firstapp0.Controller;

import com.example.firstapp0.Entity.Provider;
import com.example.firstapp0.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    @GetMapping("/addProvider")
    public String showAddProviderForm(Model model) {
        Provider provider = new Provider();
        model.addAttribute("ProviderForm", provider);
        return "add_provider";
    }


    @PostMapping("/saveProvider")
    public String saveProvider(@ModelAttribute("ProviderForm") Provider provider) {
        providerService.createProvider(provider);
        return "redirect:/allProviders";
    }


    @GetMapping("/allProviders")
    public String getAllProviders(Model model) {
        List<Provider> providers = providerService.getAllProviders();
        model.addAttribute("providers", providers);
        return "provider_list";
    }

    // 4. Display provider details by ID
    @GetMapping("/provider/{id}")
    public String getProviderById(@PathVariable int id, Model model) {
        Provider provider = providerService.getProviderById(id);  // Fetch provider by ID
        model.addAttribute("provider", provider);  // Add to the model
        return "provider_detail";  // Render provider_detail.html
    }

    // 5. Delete a provider by ID
    @GetMapping("/deleteProvider/{id}")
    public String deleteProvider(@PathVariable int id) {
        providerService.deleteProvider(id);  // Call service to delete provider
        return "redirect:/allProviders";  // Redirect to the provider list
    }

    // 6. Display form to update a provider
    @GetMapping("/updateProvider/{id}")
    public String showUpdateProviderForm(@PathVariable int id, Model model) {
        Provider provider = providerService.getProviderById(id);  // Fetch provider to edit
        model.addAttribute("provider", provider);  // Bind provider data to form
        return "updateProvider";  // Reuse add_provider.html for updates
    }

    // 7. Handle update submission
    @PostMapping("/updateProvider/{id}")
    public String updateProvider(@PathVariable int id, @ModelAttribute("ProviderForm") Provider provider) {
        providerService.updateProvider(id, provider);  // Update provider in service
        return "redirect:/allProviders";  // Redirect to provider list after update
    }
}
