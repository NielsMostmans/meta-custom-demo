# meta-custom-demo

The **meta-custom-demo** project defines a basic custom Yocto layer to boot a minimal Linux system with custom users, remote SSH access, and a sample application.
---

## Purpose

The `meta-custom-demo` layer provides:

- A custom Yocto layer based on `core-image-minimal`.
- Support for extra system users.
- Out-of-the-box SSH access.
- Example custom application recipe.

---

## Dependencies

This layer depends on:

- **Poky**
  - URI: https://git.yoctoproject.org/poky  
  - branch: `scarthgap` (or your chosen Yocto release branch)

- **meta-openembedded**
  - URI: https://git.openembedded.org/meta-openembedded  
  - branch: `scarthgap`
